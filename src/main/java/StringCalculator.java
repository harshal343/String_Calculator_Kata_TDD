import java.util.stream.Collectors;
import java.util.*;

public class StringCalculator {

    public int add(String numbers){
        int sum=0;
        if(numbers.length()!=0){
            List<Integer>ls= str_IntList(numbers);
            ifNumNegative(ls);
            sum=ls.stream().reduce(Integer::sum).orElseThrow();
        }
        return sum;
    }
    List<Integer> str_IntList(String numbers){
        numbers=removeNxtln(numbers);
        List<Integer> ls=Arrays.stream(numbers.split(",")).map(map->map.length()==1 && 'a'<=map.charAt(0) && map.charAt(0)<='z' ?   map.charAt(0)-'a'+1:Integer.parseInt(map)).filter((number)->number<=1000).collect(Collectors.toList());
        if(ls.size()==0) ls.add(0);
        return ls;
    }
    String removeNxtln(String numbers){
        if(numbers.contains("\n")){
            String[] numberString=numbers.split("\n");
            StringBuilder strBuild=new StringBuilder();
            for(String str:numberString){
                if(str.length()!=0)
                    strBuild.append(str);
                if(strBuild.length()>0 && strBuild.charAt(strBuild.length()-1)!=',')
                    strBuild.append(",");
            }
            return strBuild.toString();
        }
        return numbers;
    }
    void ifNumNegative(List<Integer> list){
        StringBuilder sNum=new StringBuilder();
        list.stream().filter(num->num<0).forEach(map->sNum.append(map).append(" "));
        if(sNum.toString().length()>0)
            throw new RuntimeException("Negatives not allowed "+ sNum.toString());
    }
}
