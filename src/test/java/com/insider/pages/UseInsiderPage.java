package com.insider.pages;

import com.insider.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.insider.utilities.Driver;
import org.openqa.selenium.support.ui.Select;

import java.rmi.Remote;

public class UseInsiderPage {
    public UseInsiderPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@id='navbarDropdownMenuLink'])[4]")
    public WebElement mainPageCompanyButton;


    @FindBy(xpath = "//a[@href='https://useinsider.com/careers/']")
    public WebElement mainPageCareersButton;


    @FindBy(xpath = "//a[@id='wt-cli-accept-btn']")
    public WebElement onlyNecessaryCookies;

    @FindBy(xpath = "//h3[@class='category-title-media ml-0']")
    public WebElement ourLocations;

    @FindBy(xpath = "//a[.='See all teams']")
    public WebElement seeAllTeams;

    @FindBy(xpath = "//img[@class='w-100 align-self-center']")
    public WebElement qualityAssuranceTeam;

    @FindBy(xpath = "//h2[.='Life at Insider']")
    public WebElement lifeAtInsider;





    @FindBy(xpath = "//a[.='See all QA jobs']")
    public WebElement seeAllQaJobs;

    @FindBy(xpath = "//select[@name='filter-by-location']")
    public WebElement filterByLocationDropDown ;


    @FindBy(xpath = "//select[@name='filter-by-department']")
    public WebElement filterByDepartmentDropDown ;

    @FindBy(xpath = "//p[.='Senior Software Quality Assurance Engineer - Remote']")
    public WebElement seniorSoftwareQualityAssuranceEngineer_RemotePosition;

    @FindBy(xpath = "//p[.='Software QA Tester- Insider Testinium Tech Hub (Remote)']")
    public WebElement softwareQaTesterInsiderTestiniumTechHub_RemotePosition;

    @FindBy(xpath = "//p[.='Software Quality Assurance Engineer (Remote)']")
    public WebElement softwareQualityAssuranceEngineer_RemotePosition;

    @FindBy(xpath = "(//span[.='Quality Assurance'])[1]")
    public WebElement seniorSoftware_QaDepartments;

    @FindBy(xpath = "(//span[.='Quality Assurance'])[2]")
    public WebElement insiderSoftware_QaDepartments;

    @FindBy(xpath = "(//span[.='Quality Assurance'])[3]")
    public WebElement software_QaDepartments ;

    @FindBy(xpath = "(//div[.='Istanbul, Turkey'])[1]")
    public WebElement seniorSoftware_QaLocation ;

    @FindBy(xpath = "(//div[.='Istanbul, Turkey'])[2]")
    public WebElement insiderSoftware_QaLocation;

    @FindBy(xpath = "(//div[.='Istanbul, Turkey'])[3]")
    public WebElement software_QaLocation;

    @FindBy(xpath = "//a[@href='https://jobs.lever.co/useinsider/78ddbec0-16bf-4eab-b5a6-04facb993ddc']")
    public WebElement viewRole1;

    @FindBy(xpath ="//input[@name='resume']")
    public WebElement aplicationForm;




}
