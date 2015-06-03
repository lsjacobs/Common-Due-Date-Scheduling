import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Main {
	public static int numberOfProblems = 10; // Todos os arquivos usam 10 problemas
    public static int numberOfJobs;
    public static ArrayList<ArrayList<Job>> problems = new ArrayList<ArrayList<Job>>();
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getDataFromTextFile();
		
		
		//Continua aqui
		
		
	}
	
	public static void getDataFromTextFile() {
		ArrayList<Integer> intFromText = new ArrayList<Integer>();
        String[] valuesFromText;
        String linesFromFile = "";
        try {
			linesFromFile = readFile ("sch10.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        linesFromFile = linesFromFile.trim().replaceAll("\n", " ");
        linesFromFile = linesFromFile.replaceAll("\\s+", ",");
        valuesFromText = linesFromFile.split(",");
        for (String s: valuesFromText){
        	intFromText.add(Integer.parseInt(s));
        }
        intFromText.remove(0); // Remove primeiro valor = nº de problemas
        numberOfJobs = intFromText.get(0);
        for (int i = 0; i < numberOfProblems; i++)
        {
            ArrayList<Job> jobs = new ArrayList<Job>();
            System.out.println();
            System.out.println("Problema " + i);
            intFromText.remove(0); // Remove o valor = nº de jobs
            for (int j = 0; j < numberOfJobs; j++)
            {
                Job tempJob = new Job();
                tempJob.setProcessingTime(intFromText.get(0)); 	//* 
                tempJob.setEarlinessTime(intFromText.get(1));  	//Copia valores
                tempJob.setTardinessTime(intFromText.get(2));; 	//*
                intFromText.remove(0);                 			//*
                intFromText.remove(0);                 			//Depois os remove
                intFromText.remove(0);                 			//*
                jobs.add(tempJob);
                System.out.println("Tempo do job " + j + ": " + tempJob.getProcessingTime() + ", " + tempJob.getEarlinessTime() + ", " + tempJob.getTardinessTime());
            }
            problems.add(jobs);
        }
	}
	
	public static String readFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } 
        finally {
            br.close();
        }
    }
}
