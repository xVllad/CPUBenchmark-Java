package bench.cpu;

import bench.IBenchmark;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CPUDigitsOfPi implements IBenchmark {
    private int digits;
    private int result;
    public void initialize(Object ... params) {

        this.digits = (Integer)params[0];
    }

    @Override
    public void warmUp() {
        computePiMagically(3000);
    }

    @Override
    @Deprecated
    public void run() {
        computePiMagically(digits);
    }

    @Override
    public void run(Object ...options) {
        int option = (Integer)options[0];
        switch (option)
        {
            case 0:
                computePiMagically(digits);
                break;
            case 1:
                //computePiByGuessing();
                break;
            case 2:
                //computePiSil();
                break;
        }
    }

    @Override
    public void cancel() {

    }

    @Override
    public void clean() {
    }

    @Override
    public String getResult() {

        return "Pi : " + pi;
    }

    private BigDecimal pi;

    private void computePiMagically(int digits)
    {
        BigDecimal a = new BigDecimal(1);
        BigDecimal b = new BigDecimal(1/Math.sqrt(2));
        BigDecimal t = new BigDecimal(0.25);
        BigDecimal x = new BigDecimal(1);
        BigDecimal y = new BigDecimal(0);
        BigDecimal two = new BigDecimal(2);

        for(int i=0;i<digits;++i)
        {
            y = a;
            a = a.add(b);
            a = a.divide(two,digits, BigDecimal.ROUND_FLOOR);
            b = b.multiply(y);
            b = sqrt(b,digits);
            t = t.subtract((y.subtract(x)).multiply(y.subtract(x)).multiply(x));
            x = x.multiply(two);
        }
        pi = (a.add(b).multiply(a.add(b))).divide(t.multiply(new BigDecimal(4)),digits,BigDecimal.ROUND_FLOOR);
    }

    private static final BigDecimal SQRT_DIG = new BigDecimal(130);
    private static final BigDecimal SQRT_PSE = new BigDecimal(10).pow(SQRT_DIG.intValue());

    private BigDecimal sqrtN(BigDecimal c,BigDecimal xn, BigDecimal pr)
    {
        BigDecimal fx = xn.pow(2).add(c.negate());
        BigDecimal fpx = xn.multiply(new BigDecimal(2));
        BigDecimal xnl = fx.divide(fpx,2*SQRT_DIG.intValue(), RoundingMode.HALF_DOWN);
        xnl = xn.add(xnl.negate());
        BigDecimal curSqrt = xnl.pow(2);
        BigDecimal curPr = curSqrt.subtract(c);
        curPr = curPr.abs();
        if(curPr.compareTo(pr) <= -1)
        {
            return xnl;
        }
        return sqrtN(c,xnl,pr);
    }

    private BigDecimal sqrt(BigDecimal a,int dig)
    {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(a.doubleValue()));
        BigDecimal TWO = new BigDecimal(2);

        while(TWO.equals(x1))
        {
            x0 = x1;
            x1 = a.divide(x0,dig,RoundingMode.HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO,dig,RoundingMode.HALF_UP);
        }

        return x1;
    }

    private void getPiSlicer(long n)
    {
        long hits = 0;
        for(long i=0;i<n;++i)
        {
            for(long j = 0;j<n;++j)
            {
                if(i * i +j * j <= n * n)
                {
                    hits++;
                }
            }
        }
        pi = new BigDecimal(4.0 * hits / (n * n));
    }

}
