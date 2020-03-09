package dynamic_beat;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSPACE1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSPACE2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();

	private String titleName;
	private String Difficulty;
	private String musicTitle;
	private Music gameMusic;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String Difficulty, String musicTitle) {
		this.titleName = titleName;
		this.Difficulty = Difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSPACE1Image, 540, 30, null);
		g.drawImage(noteRouteSPACE2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);

		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);

		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);

		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.ScreenDraw(g);
			}
		}

		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.drawString(titleName, 20, 702);
		g.drawString(Difficulty, 1190, 702);

		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);

		g.setColor(Color.LIGHT_GRAY);

		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("000000", 565, 702);
	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releasedS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall2.mp3", false).start();

	}

	public void releasedD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3", false).start();
	}

	public void releasedF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSPACE1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		noteRouteSPACE2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releasedSpace() {
		noteRouteSPACE1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		noteRouteSPACE2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall3.mp3", false).start();
	}

	public void releasedJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumsmall2.mp3", false).start();
	}

	public void releasedK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releasedL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	}

	@Override
	public void run() {
		dropNote();
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNote() {
		Beat[] beats = null;
		if (titleName.equals("Energy") && Difficulty.equals("Easy")) {

		} else if (titleName.equals("Energy") && Difficulty.equals("Hard")) {

		} else if (titleName.equals("Mighty Love") && Difficulty.equals("Easy")) {
			int startTime = 4460 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "S"), new Beat(gap * 2 + startTime, "D"),
					new Beat(gap * 4 + startTime, "S"), new Beat(gap * 6 + startTime, "D"),
					new Beat(gap * 8 + startTime, "S"), new Beat(gap * 10 + startTime, "D"),
					new Beat(gap * 12 + startTime, "S"), new Beat(gap * 14 + startTime, "D"),
					new Beat(gap * 18 + startTime, "J"), new Beat(gap * 20 + startTime, "K"),
					new Beat(gap * 22 + startTime, "J"), new Beat(gap * 24 + startTime, "K"),
					new Beat(gap * 26 + startTime, "J"), new Beat(gap * 28 + startTime, "K"),
					new Beat(gap * 30 + startTime, "J"), new Beat(gap * 32 + startTime, "K"),
					new Beat(gap * 36 + startTime, "S"), new Beat(gap * 38 + startTime, "D"),
					new Beat(gap * 40 + startTime, "S"), new Beat(gap * 42 + startTime, "D"),
					new Beat(gap * 44 + startTime, "S"), new Beat(gap * 46 + startTime, "D"),
					new Beat(gap * 48 + startTime, "J"), new Beat(gap * 49 + startTime, "K"),
					new Beat(gap * 50 + startTime, "L"), new Beat(gap * 52 + startTime, "F"),
					new Beat(gap * 52 + startTime, "Space"), new Beat(gap * 52 + startTime, "J"),
					new Beat(gap * 54 + startTime, "S"), new Beat(gap * 56 + startTime, "D"),
					new Beat(gap * 59 + startTime, "F"), new Beat(gap * 59 + startTime, "Space"),
					new Beat(gap * 59 + startTime, "J"), new Beat(gap * 61 + startTime, "L"),
					new Beat(gap * 63 + startTime, "K"), new Beat(gap * 65 + startTime, "F"),
					new Beat(gap * 65 + startTime, "Space"), new Beat(gap * 65 + startTime, "J"),
					new Beat(gap * 70 + startTime, "S"), new Beat(gap * 72 + startTime, "S"),
					new Beat(gap * 74 + startTime, "S"), new Beat(gap * 78 + startTime, "J"),
					new Beat(gap * 79 + startTime, "K"), new Beat(gap * 80 + startTime, "L"),
					new Beat(gap * 83 + startTime, "Space"), new Beat(gap * 85 + startTime, "S"),
					new Beat(gap * 87 + startTime, "D"), new Beat(gap * 89 + startTime, "S"),
					new Beat(gap * 91 + startTime, "D"), new Beat(gap * 93 + startTime, "F"),
					new Beat(gap * 96 + startTime, "Space"), new Beat(gap * 98 + startTime, "L"),
					new Beat(gap * 100 + startTime, "Space"), new Beat(gap * 102 + startTime, "S"),
					new Beat(gap * 104 + startTime, "D"), new Beat(gap * 106 + startTime, "Space"),
					new Beat(gap * 109 + startTime, "Space"), new Beat(gap * 112 + startTime, "Space"),
					new Beat(gap * 116 + startTime, "Space"), new Beat(gap * 118 + startTime, "S"),
					new Beat(gap * 119 + startTime, "D"), new Beat(gap * 120 + startTime, "F"),
					new Beat(gap * 123 + startTime, "S"), new Beat(gap * 124 + startTime, "D"),
					new Beat(gap * 125 + startTime, "F"), new Beat(gap * 126 + startTime, "J"),
					new Beat(gap * 127 + startTime, "K"), new Beat(gap * 130 + startTime, "J"),
					new Beat(gap * 133 + startTime, "K"), new Beat(gap * 136 + startTime, "L"),
					new Beat(gap * 138 + startTime, "S"), new Beat(gap * 140 + startTime, "Space"),
					new Beat(gap * 142 + startTime, "S"), new Beat(gap * 144 + startTime, "Space"),
					new Beat(gap * 146 + startTime, "Space"), new Beat(gap * 150 + startTime, "Space"),
					new Beat(gap * 152 + startTime, "Space"), new Beat(gap * 157 + startTime, "J"),
					new Beat(gap * 161 + startTime, "K"), new Beat(gap * 165 + startTime, "L"),
					new Beat(gap * 167 + startTime, "S"), new Beat(gap * 169 + startTime, "D"),
					new Beat(gap * 171 + startTime, "F"), new Beat(gap * 174 + startTime, "S"),
					new Beat(gap * 176 + startTime, "D"), new Beat(gap * 178 + startTime, "F"),
					new Beat(gap * 180 + startTime, "Space"), new Beat(gap * 181 + startTime, "L"),
					new Beat(gap * 184 + startTime, "Space"), new Beat(gap * 187 + startTime, "L"),
					new Beat(gap * 188 + startTime, "K"), new Beat(gap * 189 + startTime, "J"),
					new Beat(gap * 192 + startTime, "S"), new Beat(gap * 192 + startTime, "Space"),
					new Beat(gap * 196 + startTime, "D"), new Beat(gap * 196 + startTime, "Space"),
					new Beat(gap * 200 + startTime, "S"), new Beat(gap * 200 + startTime, "Space"),
					new Beat(gap * 207 + startTime, "J"), new Beat(gap * 207 + startTime, "Space"),
					new Beat(gap * 211 + startTime, "K"), new Beat(gap * 211 + startTime, "Space"),
					new Beat(gap * 216 + startTime, "L"), new Beat(gap * 216 + startTime, "Space"),
					new Beat(gap * 218 + startTime, "Space"), new Beat(gap * 221 + startTime, "J"),
					new Beat(gap * 223 + startTime, "K"), new Beat(gap * 225 + startTime, "L"),
					new Beat(gap * 227 + startTime, "S"), new Beat(gap * 227 + startTime, "Space"),
					new Beat(gap * 231 + startTime, "D"), new Beat(gap * 231 + startTime, "Space"),
					new Beat(gap * 235 + startTime, "S"), new Beat(gap * 235 + startTime, "Space"),
					new Beat(gap * 242 + startTime, "S"), new Beat(gap * 242 + startTime, "Space"),
					new Beat(gap * 242 + startTime, "L"), new Beat(gap * 246 + startTime, "D"),
					new Beat(gap * 246 + startTime, "Space"), new Beat(gap * 246 + startTime, "K"),
					new Beat(gap * 250 + startTime, "F"), new Beat(gap * 250 + startTime, "Space"),
					new Beat(gap * 250 + startTime, "J"), new Beat(gap * 255 + startTime, "J"),
					new Beat(gap * 257 + startTime, "K"), new Beat(gap * 259 + startTime, "K"),
					new Beat(gap * 262 + startTime, "S"), new Beat(gap * 262 + startTime, "Space"),
					new Beat(gap * 266 + startTime, "D"), new Beat(gap * 266 + startTime, "Space"),
					new Beat(gap * 270 + startTime, "S"), new Beat(gap * 270 + startTime, "Space"),
					new Beat(gap * 275 + startTime, "J"), new Beat(gap * 277 + startTime, "K"),
					new Beat(gap * 279 + startTime, "L"), new Beat(gap * 282 + startTime, "J"),
					new Beat(gap * 284 + startTime, "K"), new Beat(gap * 286 + startTime, "L"),
					new Beat(gap * 289 + startTime, "J"), new Beat(gap * 291 + startTime, "K"),
					new Beat(gap * 293 + startTime, "L"), new Beat(gap * 295 + startTime, "J"),
					new Beat(gap * 297 + startTime, "F"), new Beat(gap * 299 + startTime, "D"),
					new Beat(gap * 301 + startTime, "S"), new Beat(gap * 304 + startTime, "F"),
					new Beat(gap * 306 + startTime, "D"), new Beat(gap * 308 + startTime, "S"),
					new Beat(gap * 310 + startTime, "F"), new Beat(gap * 312 + startTime, "D"),
					new Beat(gap * 314 + startTime, "S"), new Beat(gap * 317 + startTime, "F"),
					new Beat(gap * 319 + startTime, "D"), new Beat(gap * 321 + startTime, "S"),
					new Beat(gap * 323 + startTime, "F"), new Beat(gap * 325 + startTime, "D"),
					new Beat(gap * 327 + startTime, "S"), new Beat(gap * 330 + startTime, "F"),
					new Beat(gap * 332 + startTime, "S"), new Beat(gap * 332 + startTime, "Space"),
					new Beat(gap * 336 + startTime, "D"), new Beat(gap * 336 + startTime, "Space"),
					new Beat(gap * 340 + startTime, "S"), new Beat(gap * 340 + startTime, "Space"), };
		} else if (titleName.equals("Mighty Love") && Difficulty.equals("Hard")) {

		} else if (titleName.equals("Wild Flower") && Difficulty.equals("Easy")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(startTime, "Space"), };
		} else if (titleName.equals("Wild Flower") && Difficulty.equals("Hard")) {

		}
		int i = 0;
		gameMusic.start();
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void judge(String input) {
		for(int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if(input.equals(note.getNoteType())) {
				note.judge();
				break;
			}
		}
	}
}
