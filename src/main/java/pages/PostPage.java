package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.PagesHandling;

import java.io.File;

public class PostPage extends PagesHandling {


    public PostPage(WebDriver driver) {
        super(driver);
    }

    /////////////////////////////////Locators////////////////////////////////////////////////////////
    final private By NavigateToPostButton =By.cssSelector("#root > main > div:nth-child(3) > div > div > div.flex.flex-col.min-w-0.flex-1.overflow-hidden > div.flex.flex-col.flex-1.h-full.relative.z-0.ps-5.overflow-hidden.ps-\\[46px\\] > div.w-full.flex > div > div.flex.flex-col.gap-5 > div.w-full.flex.items-start.justify-between.pe-8 > div.flex.justify-start.items-center.gap-\\[14px\\] > button");
   final private By ManageCategoriesButton = By.cssSelector("a[href='/posts']");
   final private By AddPostPlusButton = By.xpath("//button[@id=\"add-new-post\"]");
   final private By imageButton = By.id("dropzone-post-file");
   final private By SaveImageButton = By.cssSelector("#headlessui-dialog-panel-\\:rh\\: > div > div.px-6.sm\\:flex.gap-3.py-2.sm\\:flex-row-reverse.border-t.border-gray-200 > button.w-full.sm\\:w-auto.flex.items-center.gap-2.justify-center.py-2.px-4.border.border-transparent.rounded-md.shadow-sm.text-sm.font-medium.text-white.bg-primary.focus\\:outline-none.focus\\:ring-2.focus\\:ring-offset-2");
   final private By addPostItemButton = By.xpath("//button[@id=\"addNewPost\"]");
    File imagefile= new File("images/carRender.jpg");
    String imagePath=imagefile.getAbsolutePath();
    final private By SrcPost = By.xpath("//*[@id=\"scroll_bar\"]/div/div[1]");

    final private By testbtn = By.cssSelector("#root > main > div:nth-child(3) > div > div > div.flex.flex-col.min-w-0.flex-1.overflow-hidden > div.flex.flex-col.flex-1.h-full.relative.z-0.ps-5.overflow-hidden.ps-\\[46px\\] > div.w-full.flex > div > div.flex.flex-col.gap-5 > div.w-full.flex.flex-row.gap-7.overflow-x-auto.no-scrollbar.pe-8 > button:nth-child(3)");
    /////////////////////////////////////Actions///////////////////////////////////////////////////////
    public void NavigateToPostPage()
    {
            click(ManageCategoriesButton,5);
            click(NavigateToPostButton,5);
    }
    public void AddNewPost()
    {
        click(AddPostPlusButton,10);
        sendkeys(imageButton,10,imagePath);
        click(addPostItemButton,10);
    }
    public void addPostPlusBtn()
    {
        click(AddPostPlusButton,10);
    }
    public void setPostImage()
    {
        sendkeys(imageButton,10,imagePath);
    }
    public void addNewPostBtn()
    {
        click(addPostItemButton,10);
    }
}
