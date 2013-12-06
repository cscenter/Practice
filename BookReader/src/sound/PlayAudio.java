package sound;
import model.SoundModel;
import javax.sound.sampled.*;
import javax.sound.sampled.DataLine;

public class PlayAudio {

    private SoundModel audio;
    private Clip line = null;
    private int start = 0;
    private int end = 0;
    private boolean run = true;


    public PlayAudio(SoundModel model) throws InterruptedException {
        audio = model;
    }

    public void playClip() throws InterruptedException {
        try {
            DataLine.Info info = new DataLine.Info(Clip.class, audio.getAudioFormat());

            if (AudioSystem.isLineSupported(info)) {
                line = (Clip)AudioSystem.getLine(info);
                AudioFormat audioFormat = audio.getAudioFormat();
                byte[] audioBytes = audio.getAudioBytes();
                line.open(audioFormat, audioBytes, start, start - end);
                System.out.println(line.isOpen());

                line.setFramePosition(start);
                line.start();

                while (!line.isRunning())
                    Thread.sleep(10);
                while (line.isRunning())
                    Thread.sleep(10);
                line.close();
            }
        } catch (Exception e) {
        }
        line.close();
    }

    public void setStart(int value) {
        start = value;
    }
    public void setEnd(int value) {
        end = value;
    }
    public boolean getRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }



}
