import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	class Truck {
		int time, weight;

		public Truck(int time, int weight) {
			this.time = time;
			this.weight = weight;
		}

	}

	public int solution(int bridge_length, int weight, int[] truck_weights) {

		Queue<Truck> truckCrossingBridge = new LinkedList<>();
		Queue<Truck> truckList = new LinkedList<>();

		for (int i = 0; i < truck_weights.length; i++) {
			truckList.add(new Truck(0, truck_weights[i]));
		}

		int currentWeight = 0;
		int time = 0;

		while (true) {
			
			if (truckCrossingBridge.isEmpty() && truckList.isEmpty()) {
				break;
			}

			Iterator<Truck> it = truckCrossingBridge.iterator();
			while (it.hasNext()) {
				Truck t = it.next();
				t.time += 1;
				if (t.time == bridge_length) {
					currentWeight -= t.weight;
					it.remove();

				}
			}
			
			
			if (truckList.size() != 0) {

					Truck t = truckList.peek();
					if (weight >= t.weight + currentWeight) {
						truckCrossingBridge.add(t);
						currentWeight += t.weight;
						truckList.poll();
					}
			}

			time += 1;
			
		}

		return time;
	}
}