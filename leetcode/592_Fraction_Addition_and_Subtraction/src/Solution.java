class Solution {
	int numerator = 0;
	int denominator = 0;

	public int gcd(int p, int q) {
		if (q == 0) {
			return p;
		}
		return gcd(q, p % q);
	}

	public void add(int n, int d) {
		if (numerator == 0) {
			numerator = n;
			denominator = d;
		} else {
			numerator = numerator * d + (n * denominator);
			denominator = denominator * d;
		}
	}

	public String fractionAddition(String expression) {
		String[] fractions = expression.split("(?=[+-])");
		for (int i = 0; i < fractions.length; i++) {
			String[] upAndDown = fractions[i].split("/");
			add(Integer.parseInt(upAndDown[0]),Integer.parseInt(upAndDown[1]));
		}
		int gcd = gcd(Math.abs(numerator), Math.abs(denominator));
		return new StringBuilder().append(numerator / gcd).append("/").append(denominator / gcd).toString();
	}
}