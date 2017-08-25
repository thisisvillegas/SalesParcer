import java.io.*;
import java.util.regex.*;

public class SalesParcer {
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Usage: java SalesParcer <Sales Data file>");
			return;
		}
		try (BufferedReader br = new BufferedReader(
				new FileReader(args[0]))) {

                     
                        String line = br.readLine();
                        String[] initial_split = line.split(Pattern.quote("|"));
                        int clientId = Integer.parseInt(initial_split[1]);
                        int storeId = Integer.parseInt(initial_split[2]);
                        String businessDay = initial_split[3];
                        double sale = Double.parseDouble(initial_split[5]);
                        double totalDaySales = 0;
                        
                        totalDaySales += sale;
                        
                        while ((line = br.readLine()) != null){

                            String[] value_split = line.split(Pattern.quote("|"));
                            
                            if (Integer.parseInt(value_split[2]) == storeId && value_split[3].equals(businessDay)){
                                totalDaySales += Double.parseDouble(value_split[5]);

                            }else{
                                System.out.println(clientId +","+ storeId  
                                        +","+ businessDay +","+ totalDaySales);
                                storeId = Integer.parseInt(value_split[2]);
                                businessDay = value_split[3];
                                totalDaySales = Double.parseDouble(value_split[5]);
                                clientId = Integer.parseInt(value_split[1]);
                            }

                        }
                    System.out.println(clientId +","+ storeId 
                                        +","+ businessDay +","+ totalDaySales);
		}
		catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}
