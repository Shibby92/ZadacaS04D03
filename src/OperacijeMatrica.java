public class OperacijeMatrica {

	public static void main(String[] args) {
		int brojRedova = TextIO.getInt();
		int brojKolona = TextIO.getInt();
		int[][] matrica1 = kreirajMatricu(brojRedova, brojKolona);
		int[][] matrica2 = kreirajMatricu(brojRedova, brojKolona);
		int[][] matrica3 = sabiranje(matrica1, matrica2);
		int[][] matrica4 = oduzimanje(matrica1, matrica2);
		int[][] matrica5 = pomnozi(matrica1, matrica2);
		ispisiMatricu(matrica1);
		ispisiMatricu(matrica2);
		ispisiMatricu(matrica3);
		ispisiMatricu(matrica4);
		ispisiMatricu(matrica5);
	}

	private static void ispisiMatricu(int[][] matrica) {
		for(int i=0;i<matrica.length;i++){
			for(int j=0;j<matrica[i].length;j++)
				System.out.print(matrica[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}

	private static int[][] pomnozi(int[][] matrica1, int[][] matrica2) {
		int [][]niz = new int [matrica1.length][matrica2[0].length];
		if(matrica1.length!=matrica2[0].length)
			throw new IllegalArgumentException("Matrice se ne mogu mnoziti!");
		else{
			
			for(int i =0;i<niz.length;i++){
				int tmp=niz.length-1;
				for(int j=0;j<niz[i].length;j++){
					niz[i][tmp]=vratiClan(matrica1[i],dajKolonu(matrica2,j));
					tmp--;
				}

			}
		}
		return niz;
	}

	private static int vratiClan(int[] niz1, int[] niz2) {
		int clan=0;
		int temp=niz1.length-1;
		for(int i=0;i<niz1.length;i++){
			clan+=niz1[i]*niz2[temp];
			temp--;
		}
		return clan;
	}

	private static int [] dajKolonu(int[][] matrica2,int kolona) {
		int niz[] = new int [matrica2[0].length];
		for(int i=0;i<niz.length;i++){
			niz[i]=matrica2[i][kolona];
		}
		return niz;
	}

	private static int[][] oduzimanje(int[][] matrica1, int[][] matrica2) {
		int niz[][] = new int[matrica1.length][matrica1[0].length];
		if ((matrica1.length != matrica2.length)
				|| (matrica1[0].length != matrica2[0].length))
			throw new IllegalArgumentException("Matrice se ne mogu oduzimati!");
		else {
			for (int i = 0; i < niz.length; i++) {
				for (int j = 0; j < niz[i].length; j++) {
					niz[i][j] = matrica1[i][j] - matrica2[i][j];
				}
			}
		}
		return niz;
	}

	private static int[][] sabiranje(int[][] matrica1, int[][] matrica2) {
		int niz[][]=new int [matrica1.length][matrica1[0].length];
		if((matrica1.length!=matrica2.length)||(matrica1[0].length!=matrica2[0].length))
			throw new IllegalArgumentException ("Matrice se ne mogu sabirati!");
			else{
		for(int i=0;i<niz.length;i++){
			for(int j=0;j<niz[i].length;j++){
				niz[i][j]=matrica1[i][j]+matrica2[i][j];
			}
		}
			}
		return niz;
	}

	private static int[][] kreirajMatricu(int brojRedova, int brojKolona) {
		int[][] niz = new int[brojRedova][brojKolona];
		for (int i = 0; i < brojRedova; i++) {
			for (int j = 0; j < brojKolona; j++) {

				niz[i][j] = TextIO.getInt();
			}
		}
		return niz;
	}

}
