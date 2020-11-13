const path = require('path');

const publicDir = 'src/main/webapp';

const vueWorkDir = publicDir + '/vue';

module.exports = {
    devServer: {
        proxy: 'https://localhost:8100'
    },
    outputDir: 'src/main/webapp/temp',
    chainWebpack: config => {
        config
            .plugin('html')
            .tap(args => {
                args[0].template = vueWorkDir + '/index.xhtml'
                return args
            }),
            // configure public dir for static file access
            // this is needed for npm serve, otherwise the index.html
            config
                .plugin('copy')
                .use(require('copy-webpack-plugin'), [[{
                    from: path.resolve(__dirname, publicDir),
                    ignore: ['vue/**/*']
                }]]),
            config
                .entry('app')
                .clear()
                .add('./' + vueWorkDir + '/main.js')
                .end(),
            config.resolve.alias
                .set("@", path.join(__dirname, "./" + vueWorkDir))
    }
}