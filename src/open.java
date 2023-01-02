public class open
{
public void wordopen(String filename)
{
Runtime r = Runtime.getRuntime();
Process p = null;
try
	 {

String fi=filename;

String cmd[] = { "C:/Program Files/Microsoft Office/OFFICE11/WINWORD.EXE", fi };
	    p = r.exec(cmd);
	}
	 catch (Exception e) 
	{
	    System.out.println("error executing " );
	}
}
}