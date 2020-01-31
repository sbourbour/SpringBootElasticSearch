## Requirements for BookFinder

You may download ElasticSearch from this location (version 7.5.2 as of 1/21/2020):

    https://www.elastic.co/downloads/elasticsearch

Start ElasticSearch:

    elasticsearch-7.5.1\bin>elasticsearch


The application is set up to be available at port 8095.

You may access the application via Swagger:

    localhost:8095/bookfinder/swagger-ui.html

Try saving a book using the save endpoint and data in this format:

	{
	"isbn":"978-0615488233",
	"author":"Shahriar Bourbour",
	"title":"Arash the Archer",
	"releaseDate":"2011-06-30"
	}
