package miscellanea.other;

import java.util.Arrays;
import java.util.List;

public class WithholdingPTP {
    public static void main(String[] args) {
        String[] ptpsStocks = new String[]{
                "AAA", "A", "A", "ACE", "AC", "ACP", "AFRE", "AG", "AHG", "AI", "AI", "AI", "AIR", "ALD", "AL", "AND", "AP", "APL", "APL", "AP", "APO", "APO", "AP", "ARC", "ARES", "ARL", "ARNP", "ARPJ", "ARPP", "ATA", "ATL", "AT", "AZLC", "AZUR", "BA", "BAR", "BBEP", "BBPP", "BB", "BDR", "BE", "BEP", "BEP.U", "BG", "BGIO.ES", "BHL.ES", "BI", "BIP", "BIP", "BIT", "BKE", "BKEP", "BN", "BNP", "BOI", "BP", "BPM", "BP", "BPYP.PR.", "BPYP", "BPYP", "BPYP", "BPYP", "BS", "BW", "CAG", "CAN", "CAP", "CCA", "CCL", "CC", "CEQ", "CEQP", "CF", "CH", "CHK", "CIF", "CLM", "CM", "CMD", "CML", "CNP", "CNX", "COR", "CPE", "CPN", "CPP", "CQ", "CRO", "CRPP", "CRU", "CSD", "CT", "CVR", "CWP", "DB", "DB", "DB", "DB", "DB", "DB", "DB", "DB", "DC", "DCP", "DCP", "DC", "DEF", "DE", "DG", "DK", "DML", "DM", "DN", "DO", "DQ", "ECSP", "ECT", "ECTP", "EE", "EFS", "EMES", "ENB", "ENG", "ENL", "EN", "EP", "EP", "EP", "EQG", "EQ", "ERO", "ESB", "E", "ET", "ET", "ET", "ET", "ETP", "ETP", "ETP", "EU", "EVEP", "EXL", "FELP", "FGP", "FGPR", "FGPR", "FIS", "FO", "FS", "FS", "FS", "FS", "FTA", "FTAI", "FTAI", "FTAI", "FU", "FUR.ES", "FUT", "GBL", "GCC.US", "GDA", "GDVT", "GE", "GFWQ", "GL", "GL", "GLP", "GLP", "GP", "GRM", "GRP", "GRT.U", "GS", "GSJ", "GT", "GWYG", "GYR", "HCRS", "HE", "HLN", "HOT.U", "HP", "HPG", "HRBG", "HR", "HTLL", "IDI", "IE", "IEP", "IEPR", "IGLP", "JPE", "KF", "KFN", "KK", "KKR", "KKR", "KM", "KOL", "KPEQ", "KP", "KS", "KS", "KWH.U", "LAAC", "LA", "LINE", "LI", "LMR", "LMRK", "LMRK", "LMRK", "LNK", "LR", "MCE", "ME", "ME", "MEMP", "ME", "MG", "MIC.US", "MML", "MM", "MPL", "MUK", "MW", "MYT", "NAG", "NBL", "NE", "NG", "NGL", "NGL", "NGL", "NGLS", "NH", "NK", "NL", "NNUT", "NRG", "NR", "N", "NS", "NS", "NS", "NSLP", "NS", "NS", "NT", "NUSP", "NYRT.ES", "OA", "OAK", "OAK", "OCI", "ODB", "OGC", "OIL", "OKCM", "OK", "OM", "OS", "OX", "OXM", "O", "PA", "PBF", "PD", "PFD", "PL", "PN", "POP", "PP", "PS", "PSX", "PTX", "PV", "QEP", "QR", "QSP.", "QSP.U", "RG", "RIS", "RM", "RN", "RRM", "RSTR", "RT", "RUF.", "RUF.U", "RUF.U", "SC", "SDRM", "SDTT", "SE", "SG", "SHL", "SIR", "SML", "SNM", "SOY", "SP", "SPK", "SPK", "SPL", "SPLP", "SPLP", "SRG", "SRL", "SU", "SVI", "SVX", "SXC", "SXEE", "TAG", "TCG", "TC", "TE", "TL", "TN", "TON", "TP", "UA", "UC", "UCL", "UC", "UC", "UD", "UG", "UG", "UH", "UL", "UM", "UN", "UN", "UO", "USA", "USA", "USC", "USD", "US", "USM", "US", "USO", "USO", "USSP", "UU", "UVI", "UVX", "VE", "VIX", "VIX", "VL", "VL", "VNGB", "VNRA", "VNRC", "VNRS", "VTDR", "WEA", "WEI", "WE", "WLK", "WMLP", "WM", "WNR", "WP", "WP", "WP", "WPZ.US", "XXFP", "XXMU", "YC", "YC", "ZS"
        };
        String[] myStocks = new String[]{
                "VOO", "VXUS", "BNDW", "Cooper", "DRIV", "VGT", "SMH", "GSG", "COPX", "FCX", "AAPL", "NKE", "MSFT", "JPM", "NEE", "ORCL", "CRM", "SONY", "VT", "WMT", "SBUX", "TTWO", "INTC", "JNJ", "KWEB", "AQN", "BIDU", "WBD", "BABA", "SLQT", "IBM", "VIPS", "V", "NFLX"
        };
        List<String> myStocksList = Arrays.asList(myStocks);

        for (int i = 0; i < ptpsStocks.length; i++) {
            if (myStocksList.contains(ptpsStocks[i])) {
                System.out.println(ptpsStocks[i]);
            } else {
                System.out.println("Not contains " + ptpsStocks[i]);
            }
        }
    }


}
