import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
public class ReadingOperation {
	public static void main(String[] args)
	{
		StringBuilder stringBuilder = new StringBuilder();
		try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("go.txt"),"UTF-8")))
		{
			String line;
			while((line=bufferedReader.readLine())!=null)
			{
				StringBuilder append = stringBuilder.append(line).append("\n");
				System.out.println(append);
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
