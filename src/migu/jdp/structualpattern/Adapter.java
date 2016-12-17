package migu.jdp.structualpattern;

//existing interface/implementation
interface AdvancedMediaPlayer {	
	   public void playVlc(String fileName);
	   public void playMp4(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer{
	   @Override
	   public void playVlc(String fileName) {
	      System.out.println("Playing vlc file. Name: "+ fileName);		
	   }

	   @Override
	   public void playMp4(String fileName) {
	      //do nothing
	   }
}

class Mp4Player implements AdvancedMediaPlayer{

	   @Override
	   public void playVlc(String fileName) {
	      //do nothing
	   }

	   @Override
	   public void playMp4(String fileName) {
	      System.out.println("Playing mp4 file. Name: "+ fileName);		
	   }
	}


//new interface/implementation
interface MediaPlayer {
	   public void play(String audioType, String fileName);
}

/**
 * Adapter pattern works as a bridge between two incompatible interfaces. 
 * This type of design pattern comes under structural pattern as this pattern combines the 
 * capability of two independent interfaces.
 * 
 * We are demonstrating use of Adapter pattern via following example in which an 
 * audio player device can play mp3 files only and wants to use an advanced audio player capable of 
 * playing vlc and mp4 files.
 * @author migu
 *
 */
class MediaAdapter implements MediaPlayer {

	   AdvancedMediaPlayer advancedMusicPlayer;

	   public MediaAdapter(String audioType){
	   
	      if(audioType.equalsIgnoreCase("vlc") ){
	         advancedMusicPlayer = new VlcPlayer();			
	         
	      }else if (audioType.equalsIgnoreCase("mp4")){
	         advancedMusicPlayer = new Mp4Player();
	      }	
	   }

	   @Override
	   public void play(String audioType, String fileName) {
	   
	      if(audioType.equalsIgnoreCase("vlc")){
	         advancedMusicPlayer.playVlc(fileName);
	      }
	      else if(audioType.equalsIgnoreCase("mp4")){
	         advancedMusicPlayer.playMp4(fileName);
	      }
	   }
	}

class AudioPlayer implements MediaPlayer {
	   MediaAdapter mediaAdapter; 

	   @Override
	   public void play(String audioType, String fileName) {		

	      //inbuilt support to play mp3 music files
	      if(audioType.equalsIgnoreCase("mp3")){
	         System.out.println("Playing mp3 file. Name: " + fileName);			
	      } 
	      
	      //mediaAdapter is providing support to play other file formats
	      else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
	         mediaAdapter = new MediaAdapter(audioType);
	         mediaAdapter.play(audioType, fileName);
	      }
	      
	      else{
	         System.out.println("Invalid media. " + audioType + " format not supported");
	      }
	   }   
	}


public class Adapter {

	public static void main(String[] args) {
		AudioPlayer audioPlayer = new AudioPlayer();

	    audioPlayer.play("mp3", "beyond the horizon.mp3");
	    audioPlayer.play("mp4", "alone.mp4");
	    audioPlayer.play("vlc", "far far away.vlc");
	    audioPlayer.play("avi", "mind me.avi");
	}
}
