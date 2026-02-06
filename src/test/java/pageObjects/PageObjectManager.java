package pageObjects;

import utils.WaitUtils;

public class PageObjectManager {

	private final WaitUtils waitUtils;

	private LandingPage landingPage;
	private OffersPage offersPage;
	private CheckoutPage checkoutPage;

	public PageObjectManager()
	{
		this.waitUtils=new WaitUtils();
	}

	public LandingPage getLandingPage()
	{
		if(landingPage==null)
		{
			landingPage = new LandingPage(waitUtils);
		}
		return landingPage;
	}

	public OffersPage getOffersPage()
	{
		if(offersPage==null)
		{
			offersPage = new OffersPage(waitUtils);
		}
		return offersPage;
	}

	public CheckoutPage getCheckoutPage()
	{
		if(checkoutPage==null)
		{
			checkoutPage = new CheckoutPage(waitUtils);
		}
		return checkoutPage;
	}
}