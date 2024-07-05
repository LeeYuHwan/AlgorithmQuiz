import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q14171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            String city = st.nextToken();
            String code = st.nextToken();

            List<String> list;
            if(map.containsKey(code)) {
                list = map.get(code);
                list.add(city);
            }
            else {
                list = new ArrayList<>();
                list.add(city);
            }

            map.put(code, list);
        }

        int answer = 0;
        for (String code : map.keySet()) {
            List<String> codeList = map.get(code);

            for (String city : codeList) {
                String cityCode = city.substring(0, 2);
                if(!cityCode.equals(code) && map.containsKey(cityCode)){
                    List<String> cityList = map.get(cityCode);

                    for (String cityListCity : cityList) {
                        if(cityListCity.substring(0, 2).equals(code)) answer++;
                    }

                }
            }

        }

        System.out.println(answer / 2);
    }
}
