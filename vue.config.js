/*
Abbreviations:
--------------

nrs: npm run serve
nrb: npm run build

ch: checked
sk: skipped

Notes:
------

Use './' to refer to the project's root base. 
If you use '/' at the beginning of a path, it will be the root of your file system!

*/

const path = require('path');

// Reconfigure Vue to use this path instead of './'
const baseDirPath = './src/main/webapp';

// The Vue working directory. All files served by Vue (as for nrs and as well as for nrb) must be placed here
const vueWorkDirPath = baseDirPath + '/vue';

// Custom Vue assets directory name to work together with a Java project
const assetsDirName = 'design/';

// Limit for creating inline elements for images for instance. This will reduce the amount of images loaded by the main pages, and thus the 
// connections opened by the main pages, and thus page load time.
const inlineLimit = 40000;



module.exports = {


	devServer: {
		// Needed for npm run serve in order for webpack to start building locally from the correct location
		contentBase: path.join(__dirname, baseDirPath)
		// Maybe needed for Java API?
		//proxy: 'https://localhost:8100'
	},
	// Needed for npm run build, otherwise the generated files will end up in the default 'dist' directory
	outputDir: baseDirPath,

	// Only used for nrb and relative to outputDir
	assetsDir: 'design',

	// Needed because by default Vue points to index.html, and with MPA we need to point to one of our pages, preferably also an index page.
	// Relative to outputDir
	// indexPath: 'index.xhtml',

	// Disable source maps for debugging in dev, test, acc and prod environments when the environments are completely tested through
	// productionSourceMap: false,

	chainWebpack: config => {

		config.performance
			.maxEntrypointSize(400000)
			.maxAssetSize(400000)



		if (process.env.NODE_ENV === 'development') {
			// Needed for npm run serve, otherwise the configured template file won't pick up the files in our custom assets directory
			// config
			// 	.plugin('copy')
			// 	.use(require('copy-webpack-plugin'), [[{
			// 		from: path.resolve(__dirname, baseDirPath)
			// 		//from: path.resolve(__dirname, baseDirPath + '/' + assetsDirName)
			// 	}]])
		}

		// Here we actually change the Vue working directory by configuring the base template file. All files, like main.js, will be looked
		// up relatively from here
		// config
		// 	.plugin('html')
		// 	.tap(args => {
		// 		args[0].template = vueWorkDirPath + '/index.xhtml'

		// 		// Copy it to the output dir
		// 		if (process.env.NODE_ENV === 'production') {
		// 			args[0].filename = 'index.xhtml'
		// 		}
		// 		return args
		// 	})

		// When changing the Vue working dir, the location to the entry point of the app (main.js) must also be explictly set
		// config
		// 	.entry('app')
		// 	.clear()
		// 	.add('./' + vueWorkDirPath + '/main.js')
		// 	.end()

		// When changing the Vue working dir, the location of the '@' reference should also be explictly set, the default points to './src'
		config.resolve.alias
			.set("@", path.join(__dirname, vueWorkDirPath))

		// Needed for putting script files in our custom assets directory
		config.output
			.filename(assetsDirName + 'script/vue/[name].[hash:8].js')
			.chunkFilename(assetsDirName + 'script/vue/[id].[hash:8].js')

		// Needed for putting image files in our custom assets directory
		config.module
			.rule('images')
			.test(/\.(png|jpe?g|gif)(\?.*)?$/)
			.use('url-loader')
			.loader('url-loader')
			.options({
				limit: inlineLimit,
				name: assetsDirName + 'layout/image/vue/[name].[hash:8].[ext]'
			})

		// Needed for putting svg files in our custom assets directory
		config.module
			.rule('svg')
			.use('file-loader')
			.options({
				name: assetsDirName + 'layout/image/vue/[name].[hash:8].[ext]'
			})

		// Needed for putting font files in our custom assets directory
		config.module
			.rule('fonts')
			.test(/\.(woff2?|eot|ttf|otf)(\?.*)?$/i)
			.use('url-loader')
			.loader('url-loader')
			.options({
				limit: inlineLimit,
				name: assetsDirName + 'style/font/vue/[name].[hash:8].[ext]'
			})
	},

	// Needed for putting style sheet files in our custom assets directory
	css: {
		extract: {
			filename: assetsDirName + 'style/sheet/vue/[name].[hash:8].css',
			chunkFilename: assetsDirName + 'style/sheet/vue/[name].[hash:8].css'
		},
	},


	// Page name and last entry of chunks MUST be the same!
	pages: {
		// The page 'index' MUST exist AND you can't use a template for index in order to use nrs with CodeMix!
		'index': {
			entry: vueWorkDirPath + '/page/public/home/main.js',
			template: vueWorkDirPath + '/template/default.html',
			// Codemix nrs only accepts files in .html extension, for build we need the .xhtml extension for processing by JSF
			filename: process.env.NODE_ENV === 'development' ? 'index.html' : 'index.xhtml',
			title: 'Home',
			chunks: ['chunk-vendors', 'chunk-common', 'index']
		},
		'test': {
			entry: vueWorkDirPath + '/page/public/test/main.js',
			template: vueWorkDirPath + '/template/default.html',
			// Codemix nrs only accepts files in .html extension, for build we need the .xhtml extension for processing by JSF
			filename: process.env.NODE_ENV === 'development' ? 'test.html' : 'test.xhtml',
			title: 'Test',
			chunks: ['chunk-vendors', 'chunk-common', 'test']
		}
	}
}