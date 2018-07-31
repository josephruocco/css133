 <!DOCTYPEhtml>

 

<?php include "templates/include/header.php" ?>

  
	<div id="info" class="clearfix">
		<div id="history" style="/*! width:auto; */">
      	
      
    <?php foreach ( $results['articles'] as $article ) { ?>   
      <section class="category" style="margin-bottom:20px; font-size:1.1em;">
    
      <h3 class="title">
       
      <p class="color_change" style="line-height: 1.1em; margin: 0 0 .1em;">
        <a href=".?action=viewArticle&amp;articleId=<?php echo $article->id?>" class="heading--underline;"
         style="text-decoration:none; font-variant:none; "> <?php echo htmlspecialchars( $article->title )?></a>
          </p>
          
           <p class="summary">
           <?php if ( $imagePath = $article->getImagePath( IMG_TYPE_THUMB ) ) { ?>
             <a href=".?action=viewArticle&amp;articleId=<?php echo $article->id?>"> 
             <img src="<?php echo $imagePath?>" alt="Article Thumbnail" /> </a>
          </p>
          
            <?php } ?>
             </h3>   
            
         
      
             <?php if ( $article->categoryId ) { ?>
               <p >Topic: 
               <a href=".?action=archive&amp;categoryId=<?php echo $article->categoryId?>">
               <?php echo htmlspecialchars( $results['categories'][$article->categoryId]->name )?>
               </a></p>   
            <?php } ?>
      
            </p>
            <p style="font-size:1em; font-variant:none; line-height: 1.5em;"> <?php echo htmlspecialchars( $article->summary )?>
          </p> 
             <p style="font-size:1em; margin-top:10px; line-height: 1.5em;">  <a href=".?action=viewArticle&amp;articleId=<?php echo $article->id?>">Read post</a></p>
            </p> 
      </section>
         
<?php } ?>

   <p> <a href="./?action=archive" style="text-decoration:none; font-size: 2em;" title="Archives/Categories">SEE MORE POSTS</a></p> 
	</div>
		
		 
</div>

<a class="twitter-timeline" href="https://twitter.com/joeruocco?ref_src=twsrc%5Etfw">Tweets</a> 
<script async src="https://platform.twitter.com/widgets.js" charset="utf-8"></script>


<div class="share_container">
<div>




</div>


<div class="share_box">
	
    
	 <div id="joe_info" style="
    width: 100%;
">
         
         
         <div class="subscribe_box" style="
    font: 10 20px/1.4 'Open sans' , 'Helvetica';
    width: 100%;
"> <link href="//cdn-images.mailchimp.com/embedcode/classic-10_7.css" rel="stylesheet" type="text/css">
 
<div id="mc_embed_signup" style="
    font: 100 20px/1.4 'Open sans' , 'Helvetica';
    margin: 0;
    width: 100%;
">
<form action="https://twitter.us11.list-manage.com/subscribe/post?u=303fd8883e933496debcb7203&amp;id=3e90cced55" method="post" id="mc-embedded-subscribe-form" name="mc-embedded-subscribe-form" class="validate" target="_blank" novalidate="novalidate">
    <div id="mc_embed_signup_scroll">
	<h2 style="
    font: 10 20px/1.4 'Open sans' , 'Helvetica';
">2018: Story So Far </h2>
  <input id="box1" type="checkbox" />
  <label for="box1">Anxiety  </label>
  <input id="box2" type="checkbox" />
  <label for="box2">Anxiety </label>
  <input id="box3" type="checkbox" />
  <label for="box3"> Anxiety </label>
  <p>If you checked any of the above, please subscribe to my mailing list: it will relax you like a cup of Chamomile tea.</p>
 
<div class="mc-field-group">
	<label for="mce-EMAIL">Email Address </label>
	<input value="" name="EMAIL" class="required email" id="mce-EMAIL" aria-required="true" type="email">
</div>
	<div id="mce-responses" class="clear">
		<div class="response" id="mce-error-response" style="display:none"></div>
		<div class="response" id="mce-success-response" style="display:none"></div>
	</div>    <!-- real people should not fill this in and expect good things - do not remove this or risk form bot signups-->
    <div style="position: absolute; left: -5000px;" aria-hidden="true"><input name="b_303fd8883e933496debcb7203_3e90cced55" tabindex="-1" value="" type="text"></div>
    <div class="clear"><input value="Bon Voyage" name="subscribe" id="mc-embedded-subscribe" class="button" type="submit"></div>
    </div>
</form>
</div>
<script type="text/javascript" src="//s3.amazonaws.com/downloads.mailchimp.com/js/mc-validate.js"></script><script type="text/javascript">(function($) {window.fnames = new Array(); window.ftypes = new Array();fnames[0]='EMAIL';ftypes[0]='email';fnames[1]='FNAME';ftypes[1]='text';fnames[2]='LNAME';ftypes[2]='text';fnames[3]='ADDRESS';ftypes[3]='address';fnames[4]='PHONE';ftypes[4]='phone';}(jQuery));var $mcj = jQuery.noConflict(true);</script>
<!--End mc_embed_signup--></div></div>
    <div class="outro" style="
    color: white;
    top: 0;
">
        <span class="intro" style="
    color: white;
    top: 0;
"><a href="." style="/*! float: left; *//*! font-family: ; */color: white;">
  <p class="new" style="
    font-size: 1em;
"><span>J</span>  
             <span style="
    color: white;
">O</span>
          <span>R</span>
          <span style="
    color: white;
">O</span>
  </p></a> </span>
        <span class="le_blog">le blog</span>
        
        <div>
    <div>
      <p style="color: #c0c0c0; display: inline-block">{ </p><span><em>https: // </em><a id="joe_link" href="https://josephruoc.co/">josephruoc.co</a></span>
    <p style="color: #c0c0c0; display: inline-block">,</p>  <span><em>https: // </em><a id="joe_link" href="https://xelanewyork.com/ ">xelanewyork.com</a></span>   <p style="color: white; display: inline-block"> }</p>
     <p style="color: white; margin: 0;">人生天地间，忽如远行客</p>
        </div> 
 
        </div>
    </div>
</div>
    
</div>



<div class="footer"> </div>



      


</div></div></body> </html>