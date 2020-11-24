class ZD_ReverseEachWord
{
	static void reverseEachWord(String s)
	{

		System.out.println(s);
		int sl=s.length()-1;
		String r="";
		String t="";

		for(int i=0; i<=sl; i++)
		{
			t+=s.charAt(i);
			if((s.charAt(i)==' ')||(i==sl))
			{
				for(int j=t.length()-1; j>=0; j--)
				{
					r+=t.charAt(j);
					if((j==0)&&(i!=sl))
						r+=" ";
				}
				t="";
			}
		}
		System.out.println(r);
	}

	public static void main(String[] args) {
		reverseEachWord("India is a good country");
	}
}