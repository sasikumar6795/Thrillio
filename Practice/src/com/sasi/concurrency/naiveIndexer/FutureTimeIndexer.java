package com.sasi.concurrency.naiveIndexer;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * Uses only 4 threads. Downloader now implements Callable.
 * 
 * Note: htmlPage is NOT declared volatile in Weblink due to the below 
 *         memory visibility guarantee
 * 
 * Memory Visibility: Actions in a thread prior to the submission of a 
 *         Runnable or Callable task to an ExecutorService happen-before any 
 *         actions taken by that task, which in turn happen-before the result 
 *         is retrieved via Future.get().
 * 
 * Benefit: 
 *    Executor framework is used. So, we get thread management benefit!
 *    Better coordination of control flow between threads. Cleaner than wait-notify
 * 
 * Limitation:
 *    Thread blocking can be an issue
 *    
 *   */

public class FutureTimeIndexer {

	private static final long Time_FRAME = 2000000000L;

	private Deque<Weblink> queue = new ArrayDeque<>();

	// Executors
	ExecutorService downloadExecutor = Executors.newFixedThreadPool(2);
	ExecutorService indexerExecutor = Executors.newFixedThreadPool(2);
	
	

	private static class Weblink {
		private long id;
		private String title;
		private String url;
		private String host;

		private String htmlPage;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getHost() {
			return host;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public String getHtmlPage() {
			return htmlPage;
		}

		public void setHtmlPage(String htmlPage) {
			this.htmlPage = htmlPage;
		}
	}

	private static class Downloader<T extends Weblink> implements Callable<T> {
		private T weblink;

		public Downloader(T weblink) {
			this.weblink = weblink;
		}

		@Override
		public T call() throws Exception {
			try {
				String htmlPage = HttpConnect.download(weblink.getUrl());
				weblink.setHtmlPage(htmlPage);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return weblink;
		}

	}

	// Indexer doesn't need to return anything thats why it is runnable
	private static class Indexer implements Runnable {
		private Future<Weblink> future;
		private long endTime;

		public Indexer(long endTime, Future<Weblink> future) {
			
			this.endTime = endTime;
			this.future = future;
		}
		
		private Weblink weblink;

		@Override
		public void run() {
			String htmlPage = weblink.getHtmlPage();
			index(htmlPage);

		}

		private void index(String text) {
			if (text != null) {
				System.out.println("\nIndexed: " + weblink.getId() + " " + "\n");
			}

		}
	}

	public void go() {
		//within 2 seconds all the downloading seconds has to complete
		System.out.println(System.nanoTime());
		System.out.println(System.currentTimeMillis());
		long endTime =  System.nanoTime() + Time_FRAME;
		List<Future<Weblink>> futures = new ArrayList<>();
		while (queue.size() > 0) {
			Weblink weblink = queue.remove();

			// task needs to be submitted thats why new Downloader
			futures.add(downloadExecutor.submit(new Downloader<Weblink>(weblink)));
		}
		for (Future<Weblink> future : futures) {
			/*try {
				indexerExecutor.execute(new Indexer(future.get()));
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			indexerExecutor.execute(new Indexer(endTime, future));
		}
		downloadExecutor.shutdown();
		indexerExecutor.shutdown();
		
		//once the executor is shutdown no task will be executed
		//downloadExecutor.submit(new Downloader<Weblink>(new FutureIndexer().createWeblink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com")));
	}

	public void add(Weblink link) {
		queue.add(link);
	}

	public Weblink createWeblink(long id, String title, String url, String host) {
		Weblink weblink = new Weblink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);
		return weblink;
	}

	public static void main(String[] args) {
		FutureTimeIndexer futureIndexer = new FutureTimeIndexer();
		futureIndexer.add(futureIndexer.createWeblink(2000, "Taming Tiger, Part 2",
				"http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com"));
		futureIndexer.add(futureIndexer.createWeblink(2001,
				"How do I import a pre-existing Java project into Eclipse and get up and running?",
				"http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com"));
		futureIndexer.add(futureIndexer.createWeblink(2002, "Interface vs Abstract Class",
				"http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
		futureIndexer.add(futureIndexer.createWeblink(2004, "Virtual Hosting and Tomcat",
				"http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
		futureIndexer.go();

	}

}