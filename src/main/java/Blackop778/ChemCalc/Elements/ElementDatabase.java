package blackop778.chemcalc.elements;

import java.util.HashMap;
import java.util.Scanner;

import blackop778.chemcalc.functions.IOManager;
import blackop778.chemcalc.functions.InputReturn;

public abstract class ElementDatabase
{
	private static boolean initialized = false;
	private static Element[] atomicNumberArray = new Element[119];
	private static HashMap<String, Element> atomicSymbolMap = new HashMap<String, Element>();
	private static HashMap<String, Element> atomicNameMap = new HashMap<String, Element>();
	private static HashMap<Double, Element> atomicMassMap = new HashMap<Double, Element>();

	/**
	 * Fills the various maps and array with Elements
	 */
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
		byte[][] charges = {{-1, 1}, {0}, {1}, {2}, {3}, {-4, 2, 4}, {-3, 5}, {-2}, {-1}, {0}, {1}, {2}, {3},
				{-4, 2, 4}, {-3, 3, 5}, {-2, 4, 6}, {-1, 1, 5, 7}, {0}, {1}, {2}, {3}, {2, 3, 4}, {2, 3, 4, 5},
				{2, 3, 6}, {2, 3, 4, 7}, {2, 3}, {2, 3}, {2, 3}, {1, 2}, {2}, {3}, {2, 4}, {-3, 3, 5}, {-2, 4, 6},
				{-1, 1, 5}, {0}, {1}, {2}, {3}, {4}, {3, 5}, {6}, {4, 6, 7}, {3}, {3}, {2, 4}, {1}, {2}, {1, 3}, {2, 4},
				{-3, 3, 5}, {-2, 4, 6}, {-1, 1, 5, 7}, {0}, {1}, {2}, {3}, {3, 4}, {3}, {3}, {3}, {2, 3}, {2, 3}, {3},
				{3}, {3}, {3}, {3}, {3}, {2, 3}, {3}, {4}, {5}, {6}, {4, 6, 7}, {3, 4}, {3, 4}, {2, 4}, {1, 3}, {1, 2},
				{1, 3}, {2, 4}, {3, 5}, {2, 4}, {127}, {0}, {1}, {2}, {3}, {4}, {4, 5}, {3, 4, 5, 6}, {3, 4, 5, 6},
				{3, 4, 5, 6}, {3, 4, 5, 6}, {3}, {3, 4}, {3}, {127}, {127}, {127}, {127}, {127}, {127}, {127}, {127},
				{127}, {127}, {127}, {127}, {127}, {127}, {127}, {127}, {127}, {127}, {127}, {127}};
		double[] atomicMass = {1.008, 4.002602, 6.94, 9.0121, 10.81, 12.011, 14.007, 15.999, 18.998, 20.1719, 22.989,
				24.305, 26.981, 28.085, 30.973, 32.06, 34.45, 39.948, 39.0983, 40.078, 44.955, 47.867, 50.9961, 51.9961,
				54.938, 55.845, 58.933, 58.6934, 63.546, 65.38, 69.723, 72.63, 74.921, 78.971, 79.904, 83.798, 85.4678,
				87.62, 88.90584, 91.224, 92.90637, 95.95, 98, 101.07, 102.90, 106.42, 107.8682, 112.414, 114.818,
				118.710, 121.760, 127.60, 126.90, 131.293, 132.90, 137.327, 138.90, 140.116, 140.90, 144.242, 145,
				150.35, 151.964, 157.25, 158.92, 163.500, 164.93, 167.259, 168.93, 173.054, 174.9668, 178.49, 180.94,
				183.84, 186.207, 190.23, 192.217, 195.084, 196.96, 200.59, 204.38, 207.2, 208.98, 209, 210, 222, 223,
				226, 227, 232.0377, 231.03, 238.02, 237, 244, 243, 247, 247, 251, 252, 257, 258, 259, 262, 267, 268,
				271, 272, 270, 276, 281, 280, 285, 284, 289, 288, 293, 294, 294};

		// Fill the array and maps
		Element storage;
		for(int i = 0; i < atomicNumberArray.length - 1; i++)
		{
			storage = new Element(i, names[i], symbols[i], atomicMass[i], charges[i]);
			atomicNumberArray[i] = storage;
			atomicSymbolMap.put(storage.getAtomicSymbol(), storage);
			atomicNameMap.put(storage.getName(), storage);
			atomicMassMap.put(storage.getAtomicMass(), storage);
		}
	}

	/**
	 * 
	 * @return Whether or not the database has been filled
	 */
	public static boolean getInitialized()
	{
		return initialized;
	}

	/**
	 * Will initialize the data base if it hasn't been.
	 * 
	 * @param number
	 *            The atomic number of the Element that will be returned. 1 is
	 *            subtracted from this since arrays start at 0.
	 * @return The Element with a atomic number of 'number'
	 * @throws NoElementException
	 */
	public static Element atomicNumberGet(int number) throws NoElementException
	{
		if(!initialized)
		{
			initialize();
		}
		Element toReturn = atomicNumberArray[number - 1];
		if(toReturn != null)
			return toReturn;
		else
			throw new NoElementException("An element with a number of '" + number + "' could not be found.");
	}

	/**
	 * Will initialize the data base if it hasn't been. Ignores the case of the
	 * input
	 * 
	 * @param symbol
	 *            The atomic symbol of the Element that will be returned
	 * @return A Element with the atomic symbol 'symbol'
	 * @throws NoElementException
	 */
	public static Element atomicSymbolGet(String symbol) throws NoElementException
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

		Element toReturn = atomicSymbolMap.get(symbolF);
		if(toReturn != null)
			return toReturn;
		else
			throw new NoElementException("An element with a symbol of '" + symbol + "' could not be found.");
	}

	/**
	 * Will initialize the data base if it hasn't been. Ignores the case of the
	 * input.
	 * 
	 * @param name
	 *            The name of the Element that will be returned
	 * @return A Element with the name 'name'
	 * @throws NoElementException
	 *             An error stating the element requested could not be found
	 */
	public static Element atomicNameGet(String name) throws NoElementException
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

		Element toReturn = atomicNameMap.get(nameF);
		if(toReturn != null)
			return toReturn;
		else
			throw new NoElementException("An element with a name of '" + name + "' could not be found.");
	}

	public static Element atomicMassGet(double mass) throws NoElementException
	{
		if(!initialized)
		{
			initialize();
		}

		Element toReturn = atomicMassMap.get(mass);

		if(toReturn != null)
			return toReturn;
		else
			throw new NoElementException("An element with a mass of '" + mass + "' could not be found.");
	}

	public static InputReturn massUnknownInputGet(String input) throws NoElementException
	{
		Element element;
		String inputType;
		try
		{
			element = ElementDatabase.atomicNumberGet(Integer.valueOf(input));
			inputType = "number";
		}
		catch(NumberFormatException e)
		{
			if(input.length() < 4 && !input.equalsIgnoreCase("Tin"))
			{
				element = ElementDatabase.atomicSymbolGet(input);
				inputType = "symbol";
			}
			else
			{
				element = ElementDatabase.atomicNameGet(input);
				inputType = "name";
			}
		}

		return new InputReturn("mass", String.valueOf(element.getAtomicMass()), inputType);
	}

	public static InputReturn nameUnknownInputGet(String input) throws NoElementException
	{
		Element element;
		String inputType;
		try
		{
			double number = Double.valueOf(input);
			if(number % 1 == 0 && number < 119)
			{
				// 98 Could be Californium or Technetium
				if(number == 98)
				{
					Scanner dispute = IOManager.getInput("Is '98' a mass or a number? ");
					if(dispute.next().equalsIgnoreCase("mass"))
					{
						element = ElementDatabase.atomicMassGet(number);
						inputType = "mass";
					}
					else
					{
						element = ElementDatabase.atomicNumberGet((int) (number));
						inputType = "number";
					}
				}
				else
				{
					element = ElementDatabase.atomicNumberGet((int) (number));
					inputType = "number";
				}
			}
			else
			{
				element = ElementDatabase.atomicMassGet(number);
				inputType = "mass";
			}
		}
		catch(NumberFormatException e)
		{
			element = ElementDatabase.atomicSymbolGet(input);
			inputType = "symbol";
		}

		return new InputReturn("name", element.getName(), inputType);
	}

	public static InputReturn symbolUnknownInputGet(String input) throws NoElementException
	{
		Element element;
		String inputType;
		try
		{
			double number = Double.valueOf(input);
			if(number % 1 == 0 && number < 119)
			{
				// 98 Could be Californium or Technetium
				if(number == 98)
				{
					Scanner dispute = IOManager.getInput("Is '98' a mass or a number? ");
					if(dispute.next().equalsIgnoreCase("mass"))
					{
						element = ElementDatabase.atomicMassGet(number);
						inputType = "mass";
					}
					else
					{
						element = ElementDatabase.atomicNumberGet((int) (number));
						inputType = "number";
					}
				}
				else
				{
					element = ElementDatabase.atomicNumberGet((int) (number));
					inputType = "number";
				}
			}
			else
			{
				element = ElementDatabase.atomicMassGet(number);
				inputType = "mass";
			}
		}
		catch(NumberFormatException e)
		{
			element = ElementDatabase.atomicNameGet(input);
			inputType = "name";
		}

		return new InputReturn("symbol", element.getAtomicSymbol(), inputType);
	}

	public static InputReturn chargeUnknownInputGet(String input) throws NoElementException
	{
		Element element;
		String inputType;
		try
		{
			double number = Double.valueOf(input);
			if(number % 1 == 0 && number < 119)
			{
				// 98 Could be Californium or Technetium
				if(number == 98)
				{
					Scanner dispute = IOManager.getInput("Is '98' a mass or a number? ");
					if(dispute.next().equalsIgnoreCase("mass"))
					{
						element = ElementDatabase.atomicMassGet(number);
						inputType = "mass";
					}
					else
					{
						element = ElementDatabase.atomicNumberGet((int) (number));
						inputType = "number";
					}
				}
				else
				{
					element = ElementDatabase.atomicNumberGet((int) (number));
					inputType = "number";
				}
			}
			else
			{
				element = ElementDatabase.atomicMassGet(number);
				inputType = "mass";
			}
		}
		catch(NumberFormatException e)
		{
			if(input.length() < 4 && !input.equalsIgnoreCase("Tin"))
			{
				element = ElementDatabase.atomicSymbolGet(input);
				inputType = "symbol";
			}
			else
			{
				element = ElementDatabase.atomicNameGet(input);
				inputType = "name";
			}
		}

		String charges = "";
		for(int i : element.getCharges())
		{
			charges = charges + " " + String.valueOf(element.getCharges()[i]);
		}
		charges = charges.substring(0, endIndex);
	}
}
