import synthesizer.GuitarString;

/**
 * @author Cagur
 * @version 1.0
 */
public class GuitarHero {
    private static final double CONCERT_A = 440.0;
    private static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final int total = 37;

    private static double ithConcert(int i){
        return CONCERT_A * Math.pow(2,(i - 24) / 12);
    }

    public static void main(String[] args) {
        synthesizer.GuitarString[] gs = new synthesizer.GuitarString[total];
        // initial concert
        for(int i=0;i<total;i++){
            gs[i] = new GuitarString(ithConcert(i));
        }

        while(true){
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(key);
                if(index < 0){
                    System.out.println("You hit invalid key.");
                    continue;
                }
                gs[index].pluck();
            }
            /* compute the superposition of samples */
            double sample = 0;
            for (GuitarString g : gs) {
                sample+=g.sample();
            }
            StdAudio.play(sample);
            /* advance the simulation of each guitar string by one step */
            for (GuitarString g : gs) {
                g.tic();
            }
        }


    }

}
