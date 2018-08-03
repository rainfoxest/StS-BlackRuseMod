package blackrusemod.patches;

import com.megacrit.cardcrawl.characters.*;
import com.evacipated.cardcrawl.modthespire.lib.*;
import basemod.*;

public class AscensionPatch
{
    @SpirePatch(cls = "com.megacrit.cardcrawl.screens.stats.StatsScreen", method = "getVictory")
    public static class getVictoryFix
    {
        public static int Postfix(final int retVal, final AbstractPlayer.PlayerClass c) {
            if (BaseMod.playerStatsMap.get(c.toString()) != null) {
                return BaseMod.playerStatsMap.get(c.toString()).getVictoryCount();
            }
            return retVal;
        }
    }
    
    @SpirePatch(cls = "com.megacrit.cardcrawl.dungeons.AbstractDungeon", method = "dungeonTransitionSetup")
    public static class Ascension14Fix
    {
        @SpireInsertPatch(rloc = 43, localvars = { "player" })
        public static void Insert(final AbstractPlayer player) {
            switch (player.chosenClass) {
                case DEFECT: {
                    break;
                }
                case IRONCLAD: {
                    break;
                }
                case THE_SILENT: {
                    break;
                }
                default: {
                    player.decreaseMaxHealth((int)(player.maxHealth * 0.0625f));
                    break;
                }
            }
        }
    }
}
