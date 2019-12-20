package packModelo;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Par {

	String actorOPelicula;
	BigDecimal pageRank;
	
	public Par(String pString, BigDecimal pPage)
	{
		this.actorOPelicula = pString;
		this.pageRank = pPage;
	}
}
