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
	 if(pitch == null){
		 return "";
	 } else if (octave != 0){
		 String ret = pitch+octave;
		 return ret;
		 
	 } 
 
 }
	
	
	
}
