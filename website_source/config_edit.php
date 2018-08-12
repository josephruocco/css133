<?php
ini_set( "display_errors", true );
date_default_timezone_set("US/Eastern" );  // http://www.php.net/manual/en/timezones.php
define( "DB_DSN", "omitted" );
define( "DB_USERNAME","omitted" );
define( "DB_PASSWORD", "omitted" );
define( "CLASS_PATH", "classes" );
define( "TEMPLATE_PATH", "templates" );
define( "HOMEPAGE_NUM_ARTICLES", 5 );
define( "ADMIN_USERNAME", "omitted" );
define( "ADMIN_PASSWORD", "omitted" );
define( "ARTICLE_IMAGE_PATH", "images/articles" );
define( "IMG_TYPE_FULLSIZE", "fullsize" );
define( "IMG_TYPE_THUMB", "thumb" );
define( "ARTICLE_THUMB_WIDTH", 200 );
define( "JPEG_QUALITY", 85 );
require( CLASS_PATH . "/Article.php" );
require( CLASS_PATH . "/Category.php" );
 
function handleException( $exception ) {
  echo "Sorry, a problem occurred. Please try later.";
  error_log( $exception->getMessage() );
}
 
set_exception_handler( 'handleException' );
?>