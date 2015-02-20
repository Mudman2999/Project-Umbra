public class MapGenerator {
	int upper = 30;
	int lower = 5;
	int left = 0;
	int right = 800;
	int mapHeights [] = new int[3];
	int mapDistances [] = new int[3];
	MapGenerator(){
		for(int i = 0; i < 3; i++){
		mapHeights[i] =  (int) (Math.random() * (upper - lower)) + lower;
		mapDistances[i] =  (int) (Math.random() * (right - left)) + left;
		System.out.println(mapHeights[i]);
		System.out.println(mapDistances[i]);
	}
}
}
