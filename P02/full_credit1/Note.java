public class Note{
	private Pitch pitch;
	private int octave;
	public Note(){
		pitch = null;
	}
	public Note(Pitch pitch, int octave){
		this.pitch = pitch;
		this.octave = octave;
		if(octave < -5){
			this.octave = -5;
		}
		if(octave > 4){
			this.octave = 4;
		}
	}
@Override
 public String toString() {
	 String ret = "";
	 if(pitch == null){
		 ret = "";
	 } else {
		 if (octave == 0) {
			 ret = pitch.toString() + "";
		 } else {
		  ret = pitch.toString() + octave;
		 }  
		 
	 } 
	 return ret;
 
 }
	
	
	
}
