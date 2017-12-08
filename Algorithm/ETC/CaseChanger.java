package ETC;

public class CaseChanger {

    public String snakeToCamel(String input) {
        StringBuilder stb = new StringBuilder();
        String temp;
        int startIndex = 0;
        for(int i = 0; i < input.length(); ++i){
            char token = input.charAt(i);
            if(token == '_'){
                temp = getCamel(input, startIndex, i);
                stb.append(temp);
                startIndex = i+1;
            }
        }
        stb.append(getCamel(input, startIndex));
        return stb.toString();
    }


    public String getCamel(String input, int startIndex) {
        int end = input.length();
        return getCamel(input, startIndex, end);
    }

    public String getCamel(String input, int startIndex, int end) {
        String output;
        output = input.substring(startIndex + 1, end);
        output = getFirstToken(input, startIndex, output);
        return output;
    }

    public String getFirstToken(String input, int startIndex, String words) {
        String output;

        if(startIndex == 0) {
            output = input.charAt(startIndex) + words;
        }
        else {
            output = (char) (input.charAt(startIndex) - 32) + words;
        }

        return output;
    }


}
