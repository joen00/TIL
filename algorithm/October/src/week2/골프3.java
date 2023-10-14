package week2;

public class 골프3 {

	static int arr[];

	static int solution(int N, int[][] simulation_data) {
		int answer = 0;
		arr = new int[N];
		int index = 0;
		int time = 0;

		while (true) {
			if (index >= simulation_data.length)
				break;
			// 만약 방이 채워진 곳에 해당 시각만큼 다 채워줬으면 방빼기
			for (int i = 0; i < N; i++) {
				if (time >= arr[i])
					arr[i] = -1;
			}
			for (int i = 0; i < N; i++) {
				if (index >= simulation_data.length)
					break;
				if (arr[i] == -1 && simulation_data[index][0] <= time) {
					arr[i] = simulation_data[index][1] + time;
					answer = answer + (time - simulation_data[index][0]);
					index++;
				}
			}
			time++;
		}
		System.out.println(answer);
		return answer;
	}

	public static void main(String[] args) {
		int N = 2;
		int[][] simulation_data = { { 0, 8 }, { 2, 6 }, { 4, 1 }, { 5, 1 } };
		
		solution(N, simulation_data);
		
	}

}
