package com.sasi.concurrency.naiveIndexer;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sasikumar
 *
 */
public class WaitNotifyIndexer {
	private Deque<Weblink> queue = new ArrayDeque<>();

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

	private static class Downloader implements Runnable {
		private Weblink weblink;

		private Downloader(Weblink weblink) {
			this.weblink = weblink;
		}

		@Override
		public void run() {
			try {
				synchronized (weblink) {
					String htmlPage = HttpConnect.download(weblink.getUrl());
					weblink.setHtmlPage(htmlPage);
					// weblink.notify();
					weblink.notifyAll();
					System.out.println(weblink.getId() + " " + "notified the thread");
				}
				// lock is released here and it will be acquired by wait() method
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}

		}

	}

	private static class Indexer implements Runnable {
		private Weblink weblink;

		private Indexer(Weblink weblink) {
			this.weblink = weblink;
		}

		@Override
		public void run() {
			String htmlPage = weblink.getHtmlPage();
			synchronized (weblink) {

				// Standard idiom for using wait method
				//    + while condition is critical as some other thread could have acquired the 
				//    lock and changed the state of the variable or 
				//    + Due to "spurious wakeup": A waiting thread can rarely wake up in the   absence of notify.
				while (htmlPage == null) {
					try {
						System.out.println(weblink.getId() + " " + "not yet Downloaded");
						weblink.wait();
						htmlPage = weblink.getHtmlPage();
						System.out.println(weblink.getId() + " " + "awakened");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				index(htmlPage);
			}

		}

		private void index(String text) {
			if (text != null) {
				System.out.println("\nIndexed: " + weblink.getId() + "\n");
			}
		}
	}

	private Weblink createWeblink(long id, String title, String url, String host) {

		Weblink weblink = new Weblink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setUrl(url);
		weblink.setHost(host);

		return weblink;
	}

	private void add(Weblink createWeblink) {
		queue.add(createWeblink);

	}

	private void go() {
		while (queue.size() > 0) {
			Weblink weblink = queue.remove();
			Thread downloaderThread = new Thread(new Downloader(weblink));
			Thread indexerThread = new Thread(new Indexer(weblink));

			downloaderThread.start();
			indexerThread.start();
		}

	}

	public static void main(String[] args) {
		WaitNotifyIndexer waitNotifyIndexer = new WaitNotifyIndexer();
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2000, "Taming Tiger, Part 2",
				"https://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html",
				"http://www.javaworld.com"));
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2001,
				"How do I import a pre-existing Java project into Eclipse and get up and running?",
				"https://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running",
				"http://www.stackoverflow.com"));
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2002, "Interface vs Abstract Class",
				"http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
		waitNotifyIndexer.add(waitNotifyIndexer.createWeblink(2004, "Virtual Hosting and Tomcat",
				"http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
		waitNotifyIndexer.go();
	}

}
