package week4;

import java.util.*;
class PRO_주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        
        HashMap<String, Integer> inCar = new HashMap<>(); // 차량 번호, 입차 시간
        HashMap<String, Integer> sumTime = new HashMap<>(); // 차량 번호, 누적 시간
        
        for(int i=0;i<records.length;i++){
            String splitRecords[] = records[i].split(" "); // [05:34, 5961, IN]
            // System.out.println(Arrays.toString(splitRecords)); [05:34, 5961, IN]
            String splitTime[] = splitRecords[0].split(":"); // [05, 34]
            int calTime = (Integer.parseInt(splitTime[0]) * 60) + Integer.parseInt(splitTime[1]);
            // System.out.println(splitRecords[1] + " , " + calTime);
            if (splitRecords[2].equals("IN"))
                inCar.put(splitRecords[1], calTime);
            else {
                String carName = splitRecords[1];
                int inTime = inCar.get(splitRecords[1]);
                int sum = calTime - inTime;
                if (sumTime.containsKey(carName))
                    sum = sum + sumTime.get(carName);
                sumTime.put(carName, sum);
                inCar.remove(carName);
            }
            
        }
        
        List<String> keySet = new ArrayList<>(inCar.keySet());
        for(String carName : keySet){
            int inTime = inCar.get(carName);
            int sum = 1439 - inTime;
            if (sumTime.containsKey(carName))
                sum = sum + sumTime.get(carName);
            sumTime.put(carName, sum);
        }

        List<String> result = new ArrayList<>(sumTime.keySet());
        Collections.sort(result);
        int[] answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            if (sumTime.get(result.get(i)) > fees[0]){
                answer[i] = fees[1] + (int) Math.ceil((double)(sumTime.get(result.get(i)) - fees[0]) / fees[2]) * fees[3];
                // System.out.println(Math.ceil((sumTime.get(result.get(i)) - fees[0]) / fees[2]));
            }else {
                answer[i] = fees[1];
            }
        }
        // System.out.println(Arrays.toString(answer));
        
        
        return answer;
    }
}
