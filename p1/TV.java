
public class TV {
	int channel;
	int volumeLevel;
	boolean on;
	public TV(){
		channel=1;
		volumeLevel=1;
		on=false;
	}
	public void turnOn(){
		on=true;
	}
	public void turnoff(){
		on=false;
	}
	public void setChannel(int n){
		channel=n;
	}
	public void setVolumeLeve(int n){
		volumeLevel=n;
	}
	public void channelUp(){
		channel++;
	}
	public void channelDown(){
		channel--;
	}
	public void volumeLevelUp(){
		volumeLevel++;
	}
	public void volumeLeveDown(){
		volumeLevel--;
	}

}
