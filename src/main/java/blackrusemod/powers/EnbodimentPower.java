package blackrusemod.powers;

import java.util.Random;

import com.megacrit.cardcrawl.actions.common.MakeTempCardInDrawPileAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.PowerStrings;
import com.megacrit.cardcrawl.powers.AbstractPower;

import blackrusemod.BlackRuseMod;
import blackrusemod.cards.Barrier;
import blackrusemod.cards.BruteForce;
import blackrusemod.cards.Comet;
import blackrusemod.cards.Deny;

public class EnbodimentPower extends AbstractPower {
	public static final String POWER_ID = "EnbodimentPower";
	private static final PowerStrings powerStrings = CardCrawlGame.languagePack.getPowerStrings(POWER_ID);
	public static final String NAME = powerStrings.NAME;
	public static final String[] DESCRIPTIONS = powerStrings.DESCRIPTIONS;

	public EnbodimentPower(AbstractCreature owner, int amount) {
		this.name = NAME;
		this.ID = POWER_ID;
		this.owner = owner;
		this.amount = amount;
		updateDescription();
		this.img = BlackRuseMod.getEnbodimentPowerTexture();
	}
	
	public void stackPower(int stackAmount)
	{
		this.fontScale = 8.0F;
		this.amount += stackAmount;
	}

	public void atEndOfTurn(boolean isPlayer)
	{
		//flash();
		AbstractCard c;
		
		for (int i = 0; i < this.amount; i++) {
			Random random = new Random();
			int randomNum = random.nextInt(4) + 1;
			if (randomNum == 1) c = new Deny().makeCopy();
			else if (randomNum == 2) c = new Comet().makeCopy();
			else if (randomNum == 3) c = new BruteForce().makeCopy();
			else c = new Barrier().makeCopy();
		
			AbstractDungeon.actionManager.addToBottom(new MakeTempCardInDrawPileAction(c, 1, true, false));
		}
	}

	public void updateDescription()
	{
		this.description = (DESCRIPTIONS[0] + this.amount + DESCRIPTIONS[1]);
	}
}