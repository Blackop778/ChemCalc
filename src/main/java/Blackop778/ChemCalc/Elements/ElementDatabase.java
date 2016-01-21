package Blackop778.ChemCalc.Elements;

import java.util.HashMap;

public class ElementDatabase
{
	private static boolean initialized = false;
	private static Element[] atomicNumberArray = new Element[119];
	private static HashMap<String, Element> atomicSymbolMap = new HashMap<String, Element>();
	private static HashMap<String, Element> atomicNameMap = new HashMap<String, Element>();

	static void initialize()
	{
		initialized = true;
		String[] symbols = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S",
				"Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As",
				"Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn",
				"Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho",
				"Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po",
				"At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md",
				"No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Uut", "Fl", "Uup", "Lv", "Uus",
				"Uuo"};
		String[] names = {"Hydrogen", "Helium", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen", "Oxygen",
				"Flourine", "Neon", "Sodium", "Magnesium", "Aluminum", "Silicon", "Phosphorus", "Sulfur", "Chlorine",
				"Argon", " Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron",
				"Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Germanium", "Arsenic", "Selenium", "Bromine",
				"Krypton", "Rubidium", "Strontium", "Yttrium", "Zirconium", "Niobium", "Molydbenum", "Technetium",
				"Ruthenium", "Rhodium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Antimony", "Tellurium",
				"Iodine", "Xenon", "Cesium", "Barium", "Lanthanum", "Cerium", "Praseodymium", "Neodymium", "Promethium",
				"Samarium", "Europium", "Gadolinium", "Terbium", "Dysprosium", "Holmium", "Erbium", "Thulium",
				"Ytterbium", "Lutetium", "Hafnium", "Tantalum", "Tungsten", "Rhenium", "Osmium", "Iridium", "Platinum",
				"Gold", "Mercury", "Thallium", "Lead", "Bismuth", "Polonium", "Astatine", "Radon", "Francium", "Radium",
				"Actinium", "Thorium", "Protactinium", "Uranium", "Neptunium", "Plutonium", "Americium", "Curium",
				"Berkelium", "Californium", "Einsteinium", "Fermium", "Mendelevium", "Nobelium", "Lawrencium",
				"Rutherfordium", "Dubnium", "Seaborgium", "Bohrium", "Hassium", "Metinerium", "Darmstadtium",
				"Roentgenium", "Copericium", "Ununtrium", "Flerovium", "Ununpentium", "Livermorium", "Ununseptium",
				"Ununoctium"};
		byte[] charges = {1, 0, 1, 2, 3, 4, -3, -2, -1, 0, 1, 2, 3, 4, -3, -2, -1, 0, 1, 2, 3, 4, 3, 3, 2, 3, 2, 2, 2,
				2, 3, 4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 3, 3, 2, 1, 2, 3, 4, 3, -2, -1, 0, 1, 2, 3, 3, 3, 3, 3, 3,
				3, 3, 3, 3, 3, 3, 3, 3, 3, 4, 5, 6, 7, 4, 4, 4, 3, 2, 1, 2, 3, 2, -1, 0, 1, 2, 3, 4, 5, 6, 5, 3, 2, 3,
				3, 3, 3, 3, 2, 2, 3, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127, 127};
		double[] atomicMass = {1.008, 4.002602, 6.94, 9.0121, 10.81, 12.011, 14.007, 15.999, 18.998, 20.1719, 22.989,
				24.305, 26.981, 28.085, 30.973, 32.06, 34.45, 39.948, 39.0983, 40.078, 44.955, 47.867, 50.9961, 51.9961,
				54.938, 55.845, 58.933, 58.6934, 63.546, 65.38, 69.723, 72.63, 74.921, 78.971, 79.904, 83.798, 85.4678,
				87.62, 88.90584, 91.224, 92.90637, 95.95, 98, 101.07, 102.90, 106.42, 107.8682, 112.414, 114.818,
				118.710, 121.760, 127.60, 126.90, 131.293, 132.90, 137.327, 138.90, 140.116, 140.90, 144.242, 145,
				150.35, 151.964, 157.25, 158.92, 163.500, 164.93, 167.259, 168.93, 173.054, 174.9668, 178.49, 180.94,
				183.84, 186.207, 190.23, 192.217, 195.084, 196.96, 200.59, 204.38, 207.2, 208.98, 209, 210, 222, 223,
				226, 227, 232.0377, 231.03, 238.02, 237, 244, 243, 247, 247, 251, 252, 257, 258, 259, 262, 267, 268,
				271, 272, 270, 276, 281, 280, 285, 284, 289, 288, 293, 294, 294};

		// Fill element 0 in the array
		atomicNumberArray[0] = new Element(0, "Error silly,", "Error", 778, (byte) 127);
		// Fill the array and maps
		Element storage;
		for(int i = 1; i < atomicNumberArray.length; i++)
		{
			storage = new Element(i, names[i - 1], symbols[i - 1], atomicMass[i - 1], charges[i - 1]);
			atomicNumberArray[i] = storage;
			atomicSymbolMap.put(storage.getSymbol(), storage);
			atomicNameMap.put(storage.getName(), storage);
		}
	}

	public static boolean getInitialized()
	{
		return initialized;
	}

	public static Element atomicNumberGet(int number)
	{
		if(!initialized)
		{
			initialize();
		}
		return atomicNumberArray[number];
	}

	public static Element atomicSymbolGet(String symbol)
	{
		if(!initialized)
		{
			initialize();
		}
		// Format the input before getting the Element
		String symbol1 = symbol.substring(0, 1);
		symbol1 = symbol1.toUpperCase();
		String symbol2 = symbol.substring(1, symbol.length());
		symbol2 = symbol2.toLowerCase();
		String symbolF = symbol1 + symbol2;
		return atomicSymbolMap.get(symbolF);
	}

	public static Element atomicNameGet(String name)
	{
		if(!initialized)
		{
			initialize();
		}
		// Format the input before getting the Element
		String name1 = name.substring(0, 1);
		name1 = name1.toUpperCase();
		String name2 = name.substring(1, name.length());
		name2 = name2.toLowerCase();
		String nameF = name1 + name2;
		return atomicNameMap.get(nameF);
	}
}
