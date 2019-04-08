public class RecursionChallenge{
	
	public int numOfDigits(int num){
		if(num<10){
			return 1;
		}
		else{
			return 1+numOfDigits(num/10);
		}
	}
	public int countChar(String str,char ch){
		if(str.isEmpty()){
			return 0;
		}
		else{
			if(str.charAt(0)==ch){
				return 1+countChar(str.substring(1),ch);
			}
			else{
				return countChar(str.substring(1),ch);
			}
		}
	}
	public int addDigits(int num){
		if(num<10){
			return num;
		}
		else{
			return (num%10)+addDigits(num/10);
		}
	}
}