
import java.util.*;

 
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;
 
public class Demo {
 
	public static void main(String[] args) {
	    ActiveXComponent sap = new ActiveXComponent("Sapi.SpVoice");
		  
	    Dispatch sapo = sap.getObject();
	    try {
 
	        // ���� 0-100
	        sap.setProperty("Volume", new Variant(100));
	        sap.setProperty("Rate", new Variant(1));
	        
	       
	        	
	        	 System.out.println("������Ҫ�ʶ������ݣ�");
	 	        Scanner scan=new Scanner(System.in);
	 	        String str=scan.next();
	 	        // ִ���ʶ�
	 	        Dispatch.call(sapo, "Speak", new Variant(str));
	        
	       
 
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        sapo.safeRelease();
	        sap.safeRelease();
	    }
	}
}