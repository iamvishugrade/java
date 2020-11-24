class ZB_BinaryToDecimal
{
	static void binaryToDecimal(String s)
	{
		int b=0;
		int sum=0;
		int mul=1;
		int c=0;

		for(int i=s.length()-1; i>=0; i--)
		{
			mul=1;
			char ch=s.charAt(i);
			String s1=String.valueOf(ch);
			int a=Integer.parseInt(s1);
			for(int j=0;j<=c; j++)
			{
				if(j!=0)
					{mul=mul*2;}
				else{mul=mul*1;}
			}
			b=a*mul;
			sum=sum+b;
			c=c+1;
		}
		System.out.println("Binary Value is ="+s);
		System.out.println("Decimal value is ="+sum);
	}
	public static void main(String[] args) {
		binaryToDecimal("1010");
	}
}