# Changelog

Uma entrada por passo de trabalho, com data. Correções pequenas entram como sub-itens do passo.

## Não lançado

### 2026-11-14 — Texto legível sobre a cor de destaque
- **O que estava errado:** `onColorFor` escolhia `#15131C` só quando a luminância do destaque passava de 0,45. Violet escuro (`#AE94FF`, o destaque padrão, luminância 0,37) e Red escuro (`#FF8E86`, 0,42) ficavam com texto branco: 2,48:1 e 2,22:1, abaixo do AA (4,5:1). Afetava o botão principal, o segmento e o chip selecionados e a bolinha do switch ligado no tema escuro e no AMOLED. O check do `TvColorDots` era branco fixo e tinha o mesmo problema nas bolinhas claras.
- **O que mudou:**
  - `onColorFor` compara o contraste de `#15131C` e de branco com a cor e fica com o maior. Violet escuro passa a 7,4:1 e Red escuro a 8,3:1; os tons claros continuam com branco (5,3 a 6,2:1).
  - `TvColorDots`: o check usa `onColorFor` da própria bolinha (a de Material You usa o Violet escuro como referência).
  - `OnColorTest` (JVM): falha se algum tom de destaque ficar abaixo de 4,5:1 ou se a outra cor ler melhor.
  - Documentação: `AGENTS.md`, `CLAUDE.md` com `@AGENTS.md`, este `CHANGELOG.md`; arquivos locais fora do git.
- **Arquivos:** `Palette.kt`, `Components.kt`, `src/test/.../OnColorTest.kt`, `build.gradle.kts` (junit nos testes), `.gitignore`, `AGENTS.md`, `CLAUDE.md`, `CHANGELOG.md`.
- **Conferido:** build do Slap numa cópia temporária com esta versão do módulo: `:tvnclr-ui:testDebugUnitTest` (2 testes, 0 falhas), `:app:testDebugUnitTest` e `:app:assembleDebug` sem erro.
- **Pendente:** lançar `v1.0.3` (merge em `main`, tag, push) e atualizar o submódulo no OTPilot (está em `v1.0.2`) e no Slap (está em `v1.0.0`). Material You não muda: lá o texto vem do `onPrimary` do esquema dinâmico.

## 1.0.2
- Estilos de texto corrido hifenizam palavras longas; `code` e `mono` ficam da esquerda para a direita também em RTL.

## 1.0.1
- Strings da biblioteca traduzidas para mais 25 idiomas.
- Banner do README.

## 1.0.0
- Primeira versão: o design system em Compose que nasceu no Slap (tokens, temas, componentes, fundos animados).