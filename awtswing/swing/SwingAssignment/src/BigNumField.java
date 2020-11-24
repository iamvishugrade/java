import com.javax.swing.IntegerField;

public class BigNumField extends IntegerField {
	final private int LENGTH = 50;
	private char[] data;
	//private boolean isNegative;
	
	public BigNumField() {
		this("0");
	}
	public BigNumField(String data) {
		super(50);
		this.data = new char[LENGTH];
		setText(data);
	}
	
	public void setText(String data) {
		data = data.trim();
		//isNegative = data.charAt(0) == '-';
		int i, j;
		for(j=0; j < LENGTH; j++)
			this.data[LENGTH-j-1] = '0';
		for(i=data.length()-1, j=0; i>= 0; i--, j++)
			this.data[LENGTH-j-1] = data.charAt(i);

		super.setText(data);
	}
	
	public BigNumField add(BigNumField num) {
		char[] sumData = new char[LENGTH];
		int sum, carry = 0;
		/*System.out.println (num.data);
		System.out.println (data);*/
		for (int i=LENGTH-1; i >= 0; i--) {
			sum = (data[i] - '0') + (num.data[i] - '0') + carry;
			sumData[i] = (char)(sum % 10 + '0');
			carry = sum / 10; 
	    }
	    
	    BigNumField sumBigNum = new BigNumField(new String(sumData));
	    return sumBigNum;
	}
	
	public BigNumField multiply(BigNumField num) {
		char[] sumData = new char[LENGTH];
		char[] currLineMulData = new char[LENGTH];
		int mul, sum, mCarry = 0, sCarry = 0, lineCount = 0;
		
		for(int i=0; i < LENGTH; i++) {
			currLineMulData[i] = data[i];
			sumData[i] = '0';
		}
			
		for (int i=LENGTH-1; i >= 0; i--, lineCount++) {
			for (int j=LENGTH-1-lineCount; j >= 0; j--) {
				mul = (data[j] - '0') * (num.data[i] - '0') + mCarry;
				currLineMulData[j] = (char)(mul % 10 + '0');
				mCarry = mul / 10; 
				sum = sumData[j] - '0'+ currLineMulData[j] - '0' + sCarry;
				sumData[j] = (char)(sum % 10 + '0');
				sCarry = sum / 10; 
			}
			currLineMulData[LENGTH-1-lineCount] = '0';
		}
		
		BigNumField mulBigNum = new BigNumField(new String(sumData));
		sumData = null;
		currLineMulData = null;
	    return mulBigNum;
	}
}