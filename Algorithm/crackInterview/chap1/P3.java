package crackInterview.chap1;

/**
 * Created by changmin on 2018. 6. 6..
 */
public class P3 {
    /**
     * 시간 복잡도 O(n)
     * 공간 복잡도 O(n)
     */
    public String getURL(String input){
        StringBuilder output = new StringBuilder();

        for(int i = 0 ; i < input.length(); ++i){
            char token = input.charAt(i);
            if(token == ' '){
                output.append("%20");
            }else{
                output.append(token);
            }
        }

        return output.toString();
    }

    public String getURL(String input, int outputSize){
        char[] tokens = input.toCharArray();
        char[] output = new char[outputSize];
        int index = 0;
        for(int i = 0; i < tokens.length; ++i){
           if(tokens[i] == ' '){
               output[index++] = '%';
               output[index++] = '2';
               output[index++] = '0';
           }else{
               output[index++] = tokens[i];
           }
        }
        return new String(output);
    }

    public String getURLLow(String input){
        int count = 0;
        for(int i = 0; i < input.length(); ++i){
            if(input.charAt(i) == ' ')
                count += 1;
        }

        int index = 0;
        char output[] = new char[input.length() + count * 2];
        for(int i = 0; i < input.length(); ++i){
            char token = input.charAt(i);
            if(token == ' '){
                output[index++] = '%';
                output[index++] = '2';
                output[index++] = '0';
            }else {
                output[index++] = token;
            }
        }

        return new String(output);
    }

}
