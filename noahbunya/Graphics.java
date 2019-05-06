public class Graphics {
    private static String[][] pieces = {
            {
                    "         ",
                    "   (m)   ",
                    "   )m(   ",
                    "  /mmm\\  "
            },
            {
                    "         ",
                    "   [m]   ",
                    "   ]m[   ",
                    "  /mmm\\  "
            },
            {
                    "         ",
                    "  |mm|   ",
                    "   /m|   ",
                    "  /mmm\\  "
            },
            {
                    "         ",
                    "   (V)   ",
                    "   )m(   ",
                    "  /mmm\\  "
            },
            {
                    "   <M>   ",
                    "   )m(   ",
                    "   )m(   ",
                    "  /mmm\\  "
            },
            {
                    "   <*>   ",
                    "   }m{   ",
                    "   }m{   ",
                    "  /mmm\\  "
            }
    };

    public static void printBoard(){
        int bw = -1, fbw = 0;
        for(int i = 0; i < 8; i++){// board row
            for(int j = 0; j < 4; j++){// cell row
                for(int l = 0; l < 8; l++){// board col
                    Vector2 pos = new Vector2(i, l);
                    int cell;

                    switch(Board.getCell(pos)){
                        case Board.PieceTypes.w_king:

                    }
                    for(char txt: pieces[cell%10][j].toCharArray()){
                        if(cell == 20 || txt == ' ')System.out.print((char) (32+26*fbw));
                        else if(txt == 'm')System.out.print((char) (66+21*(cell/10)));
                        else if(txt == 'M')System.out.print((char) (98+21*(cell/10)));
                        else System.out.print(txt);
                    }
                    bw *= -1;
                    fbw += bw;
                }
                System.out.print('\n');
            }
            bw *= -1;
            fbw += bw;
        }
    }
}
