package sb.model;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Sha256 implements Command {
	private String text;

	public Sha256(String text) {
		this.text = text;
	}

	@Override
	public String execute() {

		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");

			md.update(text.getBytes("UTF-8"));

			byte[] digest = md.digest();

			String hash = String.format("%064x", new java.math.BigInteger(1, digest));
			return hash;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

}
