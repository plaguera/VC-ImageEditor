package object;

import java.awt.Color;

public class RGB {
	
	public static final double NTSC_RED = 0.299;
	public static final double NTSC_GREEN = 0.587;
	public static final double NTSC_BLUE = 0.114;
	
	int red, green, blue;
	
	public RGB(int red, int green, int blue) {
		setRed(red);
		setGreen(green);
		setBlue(blue);
	}
	
	public RGB(int color) {
		Color aux = new Color(color);
		setRed(aux.getRed());
		setGreen(aux.getGreen());
		setBlue(aux.getBlue());
	}
	
	public RGB() {
		this(0, 0, 0);
	}
	
	public int gray() {
		return (int) (getRed() * NTSC_RED + getGreen() * NTSC_GREEN + getBlue() * NTSC_BLUE);
	}
	
	public RGB gamma(double gamma) {
		double gammaCorrection = 1 / gamma;
		int r = (int) (255 * Math.pow((double)(getRed() / 255d), gammaCorrection));
		int g = (int) (255 * Math.pow((double)(getGreen() / 255d), gammaCorrection));
		int b = (int) (255 * Math.pow((double)(getBlue() / 255d), gammaCorrection));
		return new RGB(r,g,b);
	}
	
	public void gammaMod(double gamma) {
		double gammaCorrection = 1 / gamma;
		int r = (int) (255 * Math.pow(getRed() / 255, gammaCorrection));
		int g = (int) (255 * Math.pow(getGreen() / 255, gammaCorrection));
		int b = (int) (255 * Math.pow(getBlue() / 255, gammaCorrection));
		setRed(r);
		setGreen(g);
		setBlue(b);
	}
	
	public boolean isGrayscale() {
		if(getRed() == getGreen() && getGreen() == getBlue())
			return true;
		return false;
	}
	
	public int toInt() {
		return new Color(getRed(), getGreen(), getBlue()).getRGB();
	}

	/**
	 * @return the red
	 */
	public int getRed() {
		return red;
	}

	/**
	 * @return the green
	 */
	public int getGreen() {
		return green;
	}

	/**
	 * @return the blue
	 */
	public int getBlue() {
		return blue;
	}

	/**
	 * @param red the red to set
	 */
	public void setRed(int red) {
		this.red = red;
	}

	/**
	 * @param green the green to set
	 */
	public void setGreen(int green) {
		this.green = green;
	}

	/**
	 * @param blue the blue to set
	 */
	public void setBlue(int blue) {
		this.blue = blue;
	}
	
	public static int toInt(int red, int green, int blue) {
		int rgb = red;
		rgb = rgb << 8;
		rgb |= green;
		rgb = rgb << 8;
		rgb |= blue;
		return rgb;
	}
	
	public String toString() {
		return "RGB@" + this.hashCode() + " : " + "[" + getRed() + ", " + getGreen() + ", " + getBlue() + "]";
	}
	
}