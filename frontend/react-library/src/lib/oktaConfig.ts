export const oktaConfig = {
    clientId: '0oa6g4nzg7z1Nq23P5d7',
    issuer: 'https://dev-98845726.okta.com/oauth2/default',
    redirectUri: 'http://localhost:5173/login/callback',
    scopes: ['openid', 'profile', 'email'],
    pkce: true,
    disableHttpsCheck: true,
}