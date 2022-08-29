package com.roulette.core.user;

import java.util.List;

import com.roulette.core.bet.inside.CornerBet;
import com.roulette.core.bet.inside.FieldBet;
import com.roulette.core.bet.inside.LineBet;
import com.roulette.core.bet.inside.SplitBet;
import com.roulette.core.bet.inside.StreetBet;
import com.roulette.core.bet.outisde.ColorBet;
import com.roulette.core.bet.outisde.ColumnBet;
import com.roulette.core.bet.outisde.DozenBet;
import com.roulette.core.bet.outisde.EvenBet;
import com.roulette.core.bet.outisde.HalfBet;
import com.roulette.core.bet.strategy.nowin.DoubleBetStrategy;
import com.roulette.core.bet.strategy.nowin.JamesBondStrategy;
import com.roulette.core.bet.strategy.nowin.RandomBetStrategy;
import com.roulette.core.bet.strategy.nowin.SameBetStrategy;
import com.roulette.core.bet.strategy.nowin.SuppliedBetStrategy;
import com.roulette.core.bet.strategy.win.DalembertStrategy;
import com.roulette.core.bet.strategy.win.FibonacciStrategy;
import com.roulette.core.bet.strategy.win.GrandMartingaleStrategy;
import com.roulette.core.bet.strategy.win.MartingaleStrategy;
import com.roulette.core.bet.strategy.win.ReverseMartingaleStrategy;
import com.roulette.core.field.Field;
import com.roulette.util.Boolean;

import static com.roulette.core.field.CornerRegistry.C_14_15_17_18;
import static com.roulette.core.field.FieldRegistry.F_17;
import static com.roulette.core.field.FieldRegistry.ZERO;
import static com.roulette.core.field.LineRegistry.L_10_15;
import static com.roulette.core.field.SplitRegistry.S_1_2;
import static com.roulette.core.field.StreetRegistry.S_13_14_15;

public class UserRegistry {

    private static final int MIN_BET = 10;
    private static final int MID_BET = 100;
    private static final ColorBet DEFAULT_BET = new ColorBet(MIN_BET, Boolean.TRUE);
    private static final Long BALANCE = 10000L;

    /** Same bet users **/

    public static final User FRED = new User("Fred", new SameBetStrategy<>(new ColorBet(MIN_BET, Boolean.TRUE)), BALANCE);
    public static final User GILMORE = new User("Gilmore", new SameBetStrategy<>(new ColorBet(MIN_BET, Boolean.FALSE)), BALANCE);

    public static final User EVELINA = new User("Evelina", new SameBetStrategy<>(new EvenBet(MIN_BET, Boolean.TRUE)), BALANCE);
    public static final User ODDITY = new User("Oddity", new SameBetStrategy<>(new EvenBet(MIN_BET, Boolean.FALSE)), BALANCE);

    public static final User JOE = new User("Joe", new SameBetStrategy<>(new HalfBet(MIN_BET, Boolean.TRUE)), BALANCE);
    public static final User SAM = new User("Sam", new SameBetStrategy<>(new HalfBet(MIN_BET, Boolean.FALSE)), BALANCE);

    public static final User IREN = new User("Iren", new SameBetStrategy<>(new DozenBet(MIN_BET, Field.Dozen.D1)), BALANCE);
    public static final User TONY = new User("Tony", new SameBetStrategy<>(new DozenBet(MIN_BET, Field.Dozen.D2)), BALANCE);
    public static final User HULK = new User("Hulk", new SameBetStrategy<>(new DozenBet(MIN_BET, Field.Dozen.D3)), BALANCE);

    public static final User JESS = new User("Jess", new SameBetStrategy<>(new ColumnBet(MIN_BET, Field.Column.C1)), BALANCE);
    public static final User JOSEPH = new User("Joseph", new SameBetStrategy<>(new ColumnBet(MIN_BET, Field.Column.C2)), BALANCE);
    public static final User LEO = new User("Leo", new SameBetStrategy<>(new ColumnBet(MIN_BET, Field.Column.C3)), BALANCE);

    public static final User ZORRO = new User("Zorro", new SameBetStrategy<>(new FieldBet(MIN_BET, ZERO)), BALANCE);
    public static final User MERELYN = new User("Merelyn", new SameBetStrategy<>(new FieldBet(MIN_BET, F_17)), BALANCE);

    public static final User GEORGE = new User("George", new SameBetStrategy<>(new SplitBet(MIN_BET, S_1_2)), BALANCE);
    public static final User OPRAH = new User("Oprah", new SameBetStrategy<>(new StreetBet(MIN_BET, S_13_14_15)), BALANCE);
    public static final User CORTNEY = new User("Cortney", new SameBetStrategy<>(new CornerBet(MIN_BET, C_14_15_17_18)), BALANCE);
    public static final User TERESA = new User("Teresa", new SameBetStrategy<>(new LineBet(MIN_BET, L_10_15)), BALANCE);

    public static List<User> SAME_BET_USERS = List.of(
        FRED,
        GILMORE,
        EVELINA,
        ODDITY,
        JOE,
        SAM,
        IREN,
        TONY,
        HULK,
        JESS,
        JOSEPH,
        LEO,
        ZORRO,
        MERELYN,
        GEORGE,
        OPRAH,
        CORTNEY,
        TERESA
    );

    /** Random bet factor strategy users **/

    public static final User JOANA = new User("Joana", new SuppliedBetStrategy<>("Random Color", () -> ColorBet.random(MIN_BET)), BALANCE);
    public static final User HERK = new User("Herk", new SuppliedBetStrategy<>("Random Even", () -> EvenBet.random(MIN_BET)), BALANCE);
    public static final User PENNY = new User("Penny", new SuppliedBetStrategy<>("Random Half", () -> HalfBet.random(MIN_BET)), BALANCE);
    public static final User DOLLY = new User("Dolly", new SuppliedBetStrategy<>("Random Dozen", () -> DozenBet.random(MIN_BET)), BALANCE);
    public static final User STEPHANIE = new User("Stephanie", new SuppliedBetStrategy<>("Random Column", () -> ColumnBet.random(MIN_BET)), BALANCE);
    public static final User RANDY = new User("Randy", new SuppliedBetStrategy<>("Random Split", () -> SplitBet.random(MIN_BET)), BALANCE);
    public static final User FORREST = new User("Forrest", new SuppliedBetStrategy<>("Random Field", () -> FieldBet.random(MIN_BET)), BALANCE);
    public static final User IVAN = new User("Ivan", new SuppliedBetStrategy<>("Random Street", () -> StreetBet.random(MIN_BET)), BALANCE);
    public static final User TERRENCE = new User("Terrence", new SuppliedBetStrategy<>("Random Corner", () -> CornerBet.random(MIN_BET)), BALANCE);
    public static final User ANTONY = new User("Antony", new SuppliedBetStrategy<>("Random Line", () -> LineBet.random(MIN_BET)), BALANCE);

    public static final List<User> RANDOM_BET_FACTOR_USERS = List.of(
        JOANA,
        HERK,
        PENNY,
        DOLLY,
        STEPHANIE,
        RANDY,
        FORREST,
        IVAN,
        TERRENCE,
        ANTONY
    );

    /** Custom win strategies bet users **/

    public static final User NICO = new User("Nico", new DalembertStrategy(DEFAULT_BET), BALANCE);
    public static final User OTTO = new User("Otto", new MartingaleStrategy(DEFAULT_BET), BALANCE);
    public static final User AZAM = new User("Azam", new ReverseMartingaleStrategy(DEFAULT_BET), BALANCE);
    public static final User ZORYANA = new User("Zoryana", new GrandMartingaleStrategy(DEFAULT_BET), BALANCE);
    public static final User FABIO = new User("Fabio", new FibonacciStrategy(DEFAULT_BET), BALANCE);
    public static final User URSULA = new User("Ursula", new DoubleBetStrategy(DEFAULT_BET), BALANCE);
    public static final User JAMES = new User("James Bond", new JamesBondStrategy(), BALANCE);

    public static final List<User> WIN_STRATEGY_USERS = List.of(
        NICO,
        OTTO,
        AZAM,
        ZORYANA,
        FABIO,
        URSULA,
        JAMES
    );

    /** Fully random bet user strategy **/

    public static final User RONDO = new User("Rondo", new RandomBetStrategy(MIN_BET), BALANCE);
    public static final User ALEXA = new User("Alexa", new RandomBetStrategy(MID_BET), BALANCE);

    public static final List<User> RANDOM_BETS_USERS = List.of(
        RONDO,
        ALEXA
    );
}
