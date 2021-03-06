/*
Abbreviations:
--------------

nrs: npm run serve
nrb: npm run build

Notes:
------

Use './' to refer to the project's root base. 
If you use '/' at the beginning of a path, it will be the root of your file system!

*/

const voidTags = ['area', 'base', 'br', 'col', 'embed', 'hr', 'img', 'input', 'keygen', 'link', 'meta', 'param', 'source', 'track', 'wbr'];

class HtmlTagSelfCloser {
	apply(compiler) {
		compiler.hooks.compilation.tap(this.constructor.name, compilation => {
			compilation.hooks.htmlWebpackPluginAlterAssetTags.tap(
				this.constructor.name,

				htmlPluginData => {
					htmlPluginData.head
						.filter(tag => voidTags.includes(tag.tagName))
						.forEach(tag => {
							tag.selfClosingTag = true;

							// OR, if you use the `xhtml` option (see the notes down below):
							// option 
							tag.voidTag = true;
						});

					return htmlPluginData;
				}
			)
		});
	}
}

const path = require('path');

// Reconfigure Vue to use this path instead of './'
const baseDirPath = './src/main/webapp';

// The Vue working directory. All files served by Vue (as for nrs and as well as for nrb) must be placed here
const vueWorkDirPath = baseDirPath + '/vue';

// Custom Vue assets directory name to work together with a Java project
const assetsDirName = 'design';

// Limit for creating inline elements for images for instance. This will reduce the amount of images loaded by the main pages, and thus the 
// connections opened by the main pages, and thus page load time.
const inlineLimit = 40000;

module.exports = {

	// Page name and last entry of chunks MUST be the same!
	pages: {
		// The page 'index' MUST exist in order to use nrs with CodeMix!
		'index': {
			entry: vueWorkDirPath + '/page/public/home/Home.js',
			template: vueWorkDirPath + '/template/default.html'
		},
		//
		// IMPORTANT: only generate when layout like navigation changes!
		//
		////////////////////////////////////////////////////////////////////////
		// CRITICAL !!!!!!  change inputText and inputSecret after nrb
		////////////////////////////////////////////////////////////////////////


		// 'authentication': {
		// 	entry: vueWorkDirPath + '/page/authentication/Authentication.js',
		// 	template: vueWorkDirPath + '/template/faces.html',
		// 	filename: 'authentication/authentication.xhtml',
		// 	minify: {
		// 		// https://github.com/kangax/html-minifier
		// 		keepClosingSlash: true,
		// 		collapseWhitespace: false,
		// 	},
		// 	// https://github.com/jantimon/html-webpack-plugin
		// 	xhtml: true
		// },

		'authentication-failed': {
			entry: vueWorkDirPath + '/page/authentication/AuthenticationFailed.js',
			template: vueWorkDirPath + '/template/default.html',
			filename: 'authentication/authentication-failed.html',
		},
		'test': {
			entry: vueWorkDirPath + '/page/public/test/Test.js',
			template: vueWorkDirPath + '/template/default.html'
		},
		'member': {
			entry: vueWorkDirPath + '/page/member/home/Member.js',
			template: vueWorkDirPath + '/template/default.html',
			filename: 'member/member.html'
		},
		'profile': {
			entry: vueWorkDirPath + '/page/member/profile/Profile.js',
			template: vueWorkDirPath + '/template/default.html',
			filename: 'member/profile.html'
		},
		'events': {
			entry: vueWorkDirPath + '/page/member/events/Events.js',
			template: vueWorkDirPath + '/template/default.html',
			filename: 'member/events.html'
		}
	},

	devServer: {
		// Needed for npm run serve in order for webpack to start building locally from the correct location
		contentBase: path.join(__dirname, baseDirPath),
		// Needed for local testing, otherwise we get CORS errors in the browser
		proxy: {
			'/rest': {
				target: 'http://localhost:8080/'
			},
		},
	},
	// Needed for npm run build, otherwise the generated files will end up in the default 'dist' directory
	outputDir: baseDirPath,

	// Only used for nrb and relative to outputDir
	assetsDir: 'design',

	// Disable source maps for debugging in dev, test, acc and prod environments when the environments are completely tested through
	productionSourceMap: false,

	// Needed for putting style sheet files in our custom assets directory. Use .[hash:8].css in for cache refresh
	css: {
		extract: {
			filename: assetsDirName + '/style/sheet/vue/[name].css',
			chunkFilename: assetsDirName + '/style/sheet/vue/[name].css'
		},
	},

	chainWebpack: config => {

		// Here we actually change the Vue working directory by configuring the base template file. All files, like main.js, will be looked
		// up relatively from here
		// config
		// 	.plugin('html')
		// 	.tap(args => {
		// 		args[0].template = vueWorkDirPath + '/template/default.html'

		// 		return args
		// 	})

		// Needed to avoud warnings about too big files and performance issues
		config.performance
			.maxEntrypointSize(400000)
			.maxAssetSize(400000)

		// When changing the Vue working dir, the location of the '@' reference should also be explictly set, the default points to './src'
		config.resolve.alias
			.set("@", path.join(__dirname, vueWorkDirPath))

		// Needed for putting script files in our custom assets directory
		config.output
			.filename(assetsDirName + '/script/vue/[name].js')
			.chunkFilename(assetsDirName + '/script/vue/[id].js')

		// Needed for putting image files in our custom assets directory
		config.module
			.rule('images')
			.test(/\.(png|jpe?g|gif)(\?.*)?$/)
			.use('url-loader')
			.loader('url-loader')
			.options({
				limit: inlineLimit,
				name: assetsDirName + '/layout/image/vue/[name].[ext]'
			})

		// Needed for putting svg files in our custom assets directory
		config.module
			.rule('svg')
			.use('file-loader')
			.options({
				name: assetsDirName + '/layout/image/vue/[name].[ext]'
			})

		// Needed for putting font files in our custom assets directory
		config.module
			.rule('fonts')
			.test(/\.(woff2?|eot|ttf|otf)(\?.*)?$/i)
			.use('url-loader')
			.loader('url-loader')
			.options({
				limit: inlineLimit,
				name: assetsDirName + '/style/font/vue/[name].[ext]'
			})

		// Needed for making the JSF pages for authentication XHTML compatible
		config
			.plugin('html-webpack-self-closer')
			.use(HtmlTagSelfCloser)
			.after('prefetch-authentication').after('prefetch-authentication-failed')
	}
}