package Controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
	String processo = null;
	@SuppressWarnings("deprecation")
	public void Process(String process) {
		try {
			Process read = Runtime.getRuntime().exec(process);
			InputStream flow = read.getInputStream();
			InputStreamReader reading = new InputStreamReader(flow);
			BufferedReader buffer = new BufferedReader(reading);
			String line = buffer.readLine();

			while (line != null) {
				System.out.println(line);
				line = buffer.readLine();
			}
		} catch (Exception e) {
		}
	}

	public void Killpid(int pid, String qualSO) {
		StringBuffer buffer = new StringBuffer();	
		if (qualSO.contains("Windows")) { 
			processo = "TASKKILL /PID "; 
		} 
		if(qualSO.contains("Linux")){
			processo = "kill -9 ";
		}
		try {
			buffer.append(processo); 
			buffer.append(pid);
		} catch (Exception a) {
			System.out.println(a);
		}
		Process(buffer.toString());
	}

	public void Killname(String nome, String qualSO) {
		StringBuffer buffer = new StringBuffer();
		String processo = null;
		if (qualSO.contains("Windows")) { 
			processo = "TASKKILL /IM "; 
		} 
		if(qualSO.contains("Linux")) {
			processo = "pkill -f ";
		}
		try {
			buffer.append(processo);
			buffer.append(nome);
		} catch (Exception a) {
			
		}
		Process(buffer.toString());
	}
}