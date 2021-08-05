package WordThreading;

import java.util.Random;

public class WordArray {
	public static final int NO_OF_WORDS = 390; 
	//15 Words Per Letter
	public static final String[] wordRepository={
		//A
		"abuts","abuzz", "abyes", "abysm", "abyss", "acari", "acerb",
		"aceta", "ached", "aches", "achoo", "acids", "acidy", "acing",
		"acini",
		//B
		"beaux", "bebop", "becap", "becks", "bedel", "bedew", "bedim", 
		"beech", "beedi", "beefs", "beefy", "beeps", "beers",  "beery", 
		"beets",
		//C
		"chais", "chalk", "champ", "chams", "chang", "chant", "chaos", 
		"chape", "chaps", "chapt", "chard", "chare", "chark", "charm", 
		"charr",
		//D
		"dippy", "dipso", "diram", "direr", "dirge", "dirks", "dirls", 
		"dirts", "dirty", "disci", "disco", "discs", "dishy", "disks",
		"disme",
		//E
		"event", "evert", "every", "evict", "evils", "evite", "evoke", 
		"ewers", "exact", "exalt", "exams", "excel", "execs", "exert", 
		"exile",
		//F
		"frets", "friar", "fried", "frier", "fries", "frigs", "frill", 
		"frise", "frisk", "frith", "frits", "fritt", "fritz", "frizz", 
		"frock",
		//G
		"gusto", "gusts", "gusty", "gutsy", "gutta", "gutty", "guyed", 
		"guyot", "gwine", "gybed", "gybes", "gyoza", "gypsy", "gyral", 
		"gyred",
		//H
		"hasty", "hatch", "hated", "hater", "hates", "haugh", "haulm",
		"hauls", "haunt", "haute", "haven", "haver", "haves", "havoc",
		"hawed",
		//I
		"idled", "idler", "idles", "idols", "idyll", "idyls", "igged", 
		"igloo", "iglus", "ihram", "ikats", "ikons", "ileac", "ileal", 
		"ileum",
		//J
		"jumbo", "jumps", "jumpy", "junco", "junks", "junky", "junta", 
		"junto", "jupes", "jupon", "jural", "jurat", "jurel", "juror",
		"justs",
		//K
		"kaifs", "kails", "kains", "kakas", "kakis", "kalam", "kales", 
		"kalif", "kalpa", "kames", "kamik", "kanas", "kanes", "kanji", 
		"kanzu",
		//L
		"lawny", "laxer", "laxes", "laxly", "layed", "layer", "layin", 
		"layup", "lazar", "lazed", "lazes", "leach", "leads", "leady",
		"leafs",
		//M
		"mells", "melon", "melts", "melty", "memes", "memos", "menad", 
		"mends", "mensa", "mense", "mensh", "menta", "menus", "meous",
		"meows",
		//N
		"noily", "noirs", "noise", "noisy", "nolos", "nomad", "nomas",
		"nomen", "nomes", "nomoi", "nomos", "nonas", "nonce", "nones",
		"nonet",
		//O
		"opium", "opsin", "opted", "optic", "orach", "orals", "orang", 
		"orate", "orbed", "orbit", "orcas", "orcin", "order", "ordos",
		"oread",
		//P
		"pious", "pipal", "piped", "piper", "pipes", "pipet", "pipit",
		"pique", "pirns", "pirog", "pisco", "pisos", "piste", "pitas",
		"pitch",
		//Q
		"quill", "quilt", "quins", "quint", "quips", "quipu", "quire", 
		"quirk", "quirt", "quite", "quits", "quods", "quoin", "quoit",
		"quoll",
		//R
		"rheme", "rheum", "rhino", "rhomb", "rhumb", "rhyme", "rhyta", 
		"rials", "riant", "riata", "ribby", "ribes", "riced", "ricer", 
		"rices",
		//S [17 words]
		"scabs", "scads", "scags", "scald", "scale", "scall", "scalp", 
		"scaly", "scamp", "scams", "scans", "scant", "scape", "scare", 
		"scarf", "scarp", "scars",
		//T
		"twain", "twang", "twats", "tweak", "tweed", "tween", "tweet", 
		"twerp", "twice", "twier", "twigs", "twill", "twine", "twins", 
		"twiny",
		//U
		"unrip", "unsay", "unset", "unsew", "unsex", "untie", "until", 
		"unwed", "unwet", "unwit", "unwon", "unzip", "upbow", "upbye", 
		"updos",
		//V
		"vairs", "vakil", "vales", "valet", "valid", "valor", "valse", 
		"value", "valve", "vamps", "vampy", "vanda", "vaned", "vanes",
		"vangs",
		//W
		"welch", "welds", "wells", "welly", "welsh", "welts", "wench", 
		"wends", "wenny", "wests", "wetly", "whack", "whale", "whamo", 
		"whams",
		//X [13 words]
		"xebec", "xenia", "xenic", "xenon", "xeric", "xerox", "xerus", 
		"xylan", "xylem", "xylol", "xylyl", "xysti", "xysts",
		//Y
		"yonis", "yores", "young", "yourn", "yours", "youse", "youth", 
		"yowed", "yowes", "yowie", "yowls", "yuans", "yucas", "yucca", 
		"yucch",
		//Z
		"zebra", "zebus", "zeins", "zerks", "zeros", "zests", "zesty", 
		"zetas", "zibet", "zilch", "zills", "zincs", "zincy", "zineb", 
		"zines"
	};

}
