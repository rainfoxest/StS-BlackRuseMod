package blackrusemod.cards;

import com.badlogic.gdx.graphics.Color;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DamageAction;
import com.megacrit.cardcrawl.actions.utility.WaitAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.VulnerablePower;
import com.megacrit.cardcrawl.powers.WeakPower;
import com.megacrit.cardcrawl.vfx.combat.WeightyImpactEffect;

import basemod.abstracts.CustomCard;
import blackrusemod.BlackRuseMod;
import blackrusemod.patches.AbstractCardEnum;

public class PendulumOfEternity extends CustomCard {
	public static final String ID = "PendulumOfEternity";
	private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
	public static final String NAME = cardStrings.NAME;
	public static final String DESCRIPTION = cardStrings.DESCRIPTION;
	private static final int COST = 5;
	private static final int COST_UPGRADED = 4;
	private static final int DEBUFFS = 3;
	private static final int ATTACK_DMG = 33;
	
	public PendulumOfEternity() {
		super(ID, NAME, BlackRuseMod.makePath(BlackRuseMod.PENDULUM), COST, DESCRIPTION,
				AbstractCard.CardType.ATTACK, AbstractCardEnum.SILVER,
				AbstractCard.CardRarity.RARE, AbstractCard.CardTarget.ENEMY);
		this.magicNumber = this.baseMagicNumber = DEBUFFS;
		this.baseDamage = ATTACK_DMG;
	}
	
	public void use(AbstractPlayer p, AbstractMonster m) {
		AbstractDungeon.actionManager.addToBottom(new VFXAction(new WeightyImpactEffect(m.hb.cX, m.hb.cY, new Color(0.0F, 1.0F, 1.0F, 1.0F))));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new VFXAction(new WeightyImpactEffect(m.hb.cX, m.hb.cY, new Color(0.0F, 1.0F, 1.0F, 1.0F))));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new VFXAction(new WeightyImpactEffect(m.hb.cX, m.hb.cY, new Color(0.0F, 1.0F, 1.0F, 1.0F))));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new WaitAction(0.1F));
		AbstractDungeon.actionManager.addToBottom(new DamageAction(m, new DamageInfo(p, this.damage, this.damageTypeForTurn),
				AbstractGameAction.AttackEffect.BLUNT_HEAVY));
		AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new VulnerablePower(m, this.magicNumber, false), this.magicNumber));
		AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(m, p, new WeakPower(m, this.magicNumber, false), this.magicNumber));
	}
	
	public void triggerOnManualDiscard() {
		this.superFlash();
		if (this.cost > 0) this.cost -= 1;
		this.isCostModified = true;
	}
	
	public AbstractCard makeCopy() {
		return new PendulumOfEternity();
	}
	
	public void upgrade() {
		if (!this.upgraded) {
			upgradeName();
			upgradeBaseCost(COST_UPGRADED);
		}
	}
}