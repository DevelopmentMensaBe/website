const path = require('path');

const publicDir = 'src/main/webapp';

const vueWorkDir = publicDir + '/vue';

module.exports = {
    devServer: {
        proxy: 'https://localhost:8100'
    },
    // For build only
    outputDir: publicDir + '/tmp',

    chainWebpack: config => {

        const inlineLimit = 10000;

        if (process.env.NODE_ENV === 'production') {
            // configure public dir for ignoring files in src/main/webapp that don't need vue processing (serving)
            // this is needed for npm run build
            config
                .plugin('copy')
                .use(require('copy-webpack-plugin'), [[{
                    from: path.resolve(__dirname, publicDir),
                    ignore: ['index.xhtml', 'test.xhtml', '.gitignore', 'design/**/*', 'authentication/**/*', 'member/**/*', 'META-INF/**/*', 'WEB-INF/**/*']
                }]])
        } else {
            // configure public dir for static file access
            // this is needed for npm serve, otherwise the index.xhtml won't pick up the files in the strc/main/webapp/design folder
            config
                .plugin('copy')
                .use(require('copy-webpack-plugin'), [[{
                    from: path.resolve(__dirname, publicDir)
                }]])
        }
        config
            .plugin('html')
            .tap(args => {
                // Read the index.xhtml from the vue work dir
                args[0].template = vueWorkDir + '/index.xhtml'
                // Copy it to the output dir
                if (process.env.NODE_ENV === 'production') {
                    args[0].filename = 'index.xhtml'
                }
                return args
            }),

            config
                .entry('app')
                .clear()
                .add('./' + vueWorkDir + '/main.js')
                .end(),
            config.resolve.alias
                .set("@", path.join(__dirname, "./" + vueWorkDir)),


            config
                .output
                .filename('design/script/[name].[hash:8].js')
                .chunkFilename('design/script/chunk[id].[hash:8].js')

        config.module
            .rule('images')
            .test(/\.(png|jpe?g|gif|svg)(\?.*)?$/)
            .use('url-loader')
            .loader('url-loader')
            .options({
                limit: inlineLimit,
                name: 'design/layout/image/[name].[hash:8].[ext]'
            })

        config.module.rule('svg').use('file-loader').options({
            name: 'design/layout/image/[name].[hash:8].[ext]'
        })

        config.module
            .rule('fonts')
            .test(/\.(woff2?|eot|ttf|otf)(\?.*)?$/i)
            .use('url-loader')
            .loader('url-loader')
            .options({
                limit: inlineLimit,
                name: 'design/style/font/[name].[hash:8].[ext]'
            })
    },

    css: {
        extract: {
            filename: 'design/style/sheet/[name].[hash:8].css',
            chunkFilename: 'design/style/sheet/[name].[hash:8].css'
        },
    },
}