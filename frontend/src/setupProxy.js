const { createProxyMiddleware } = require('http-proxy-middleware');

const mappingPath = ['/members', '/commons', '/items', '/articles']

module.exports = function(app){
    app.use(
        createProxyMiddleware(mappingPath, {
            target: 'http://localhost:8080',
            changeOrigin: true
        })
    )
};